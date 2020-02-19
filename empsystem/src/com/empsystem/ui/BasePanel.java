/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.ui;

import com.empsystem.dao.DepartmentDao;
import com.empsystem.dao.DepartmentDaoImpl;
import com.empsystem.dao.EmployeeDao;
import com.empsystem.dao.EmployeeDaoImpl;
import com.empsystem.dao.ProjectDao;
import com.empsystem.dao.ProjectDaoImpl;
import com.empsystem.entity.Department;
import com.empsystem.entity.TableManager;
import com.empsystem.entity.Employee;
import com.empsystem.entity.PanelStore;
import com.empsystem.entity.Project;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import static com.empsystem.ui.PanelConstant.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JComboBox;



/**
 *
 * @author Michael
 */
public abstract class BasePanel extends javax.swing.JPanel {
    protected ProjectDao projectDao;
    protected DepartmentDao departmentDao;
    protected EmployeeDao employeeDao;
    public static Employee loginEmployee; // login user detail
    protected TableManager tableManager;
    protected PanelStore ps;
    
    public BasePanel(PanelStore ps) {        
        this.ps = ps;        
        projectDao=new ProjectDaoImpl();
        departmentDao=new DepartmentDaoImpl();
        employeeDao=new EmployeeDaoImpl();
        
        init();        
    }
    
    public abstract void init();
    
    public abstract void setupPage(); 

    public void setLoginEmployee(Employee loginEmployee) {
        BasePanel.loginEmployee = loginEmployee;
    } 
         
    public void logout(){
        int n = JOptionPane.showConfirmDialog(this,"Are you sure to logout?","Logout",JOptionPane.YES_NO_OPTION);          
        System.out.println("showConfirmDialog:" + n);
        if (n == JOptionPane.YES_OPTION) {            
            ps.showJPanel(LOGIN_PANEL);
            System.out.println(loginEmployee.getUsername()+" Logout succed");
            setLoginEmployee(null);
        }
    }
        
    // Task Table -> StaffMainPanelUI, ManagerMainPanelUI
    public DefaultTableModel getStaffTaskTableModel(ArrayList<Project> inputList){ 
        Object[][] table=new Object[inputList.size()][];
        int rowId=0;                       
        for(Project p: inputList) {
            table[rowId++]=new Object[]{p.getProject_id(),p.getTask_id(),p.getProject_name(),p.getProject_leader(),
                                        p.getEmp_no(),p.getStart_date(),p.getEnd_date(),p.getDuration(),p.getTask_description()};
        }  
        DefaultTableModel model = new DefaultTableModel(table, new Object[]{"Project ID", "Task ID", "Project Name", "Project Leader","Employee No", "Start Date","End Date","Duration","Task Description"});    
        return model;
    }
               
    // Project Table -> ManagerMainPanelUI, EditProjectPanelUI
    public DefaultTableModel getProjectTableModel(ArrayList<Project> inputList){
        Object[][] table=new Object[inputList.size()][];
        int rowId=0;              
        for(Project p: inputList){
            table[rowId++]=new Object[]{p.getProject_id(), p.getProject_leader(), p.getProject_name(), p.getStart_date(), p.getEnd_date(),
                         p.getDuration(), p.getDescription()};            
        }
        DefaultTableModel model = new DefaultTableModel(table, new Object[]{"Project ID", "Project Leader", "Project Name", "Start Date", "End Date", "Duration","Descriptiton"});
        return model;
    }            
    
    // Manager Paenl -> Edit Task : top right Table
    public DefaultTableModel getProjectMemberTableModel(ArrayList<TableManager> inputList){
        Object[][] table=new Object[inputList.size()][];
        int rowId=0;
        for(TableManager t: inputList){
            table[rowId++] = new Object[]{ t.getProject().getProject_id(),t.getProject().getProject_name(),t.getProject().getTask_id(),t.getEmployee().getEmployee_no(),
                                         t.getEmployee().getFirst_name(),t.getEmployee().getLast_name(),t.getEmployee().getTitle(),t.getEmployee().getGender(),t.getProject().getTask_description()};
        }
        
        DefaultTableModel model = new DefaultTableModel(table, new Object[]{"Project ID", "Project Name", "Task ID", "Employee No", "First Name", "Last Name", "Title", "Gender","Dscription"});
        return model;
    }
    
    // ManagerPanelUI, EditProjectPanelUI's Edit Project-> : Bottom Table
    public DefaultTableModel getDepartmentMemberTableModel(ArrayList<Department> inputList){
        Object[][] table=new Object[inputList.size()][];
        int rowId=0;                 
        for(Department d: inputList) {
            table[rowId++]= new Object[]{d.getEmployee_no(),d.getTitle(),d.getFirst_name(),d.getLast_name(),d.getDepartment_from_date(),
                d.getDepartment_to_date(),d.getGender(),d.getHire_date(),d.getCurrent_partake_count(),
                d.getTotal_partake_count()};
        }        
        DefaultTableModel model = new DefaultTableModel(table, new Object[]{"Employee No.", "Title", "First Name", "Last Name","From Date","To Date", "Gender", "Hire Date", "Current Job Count", "Total Job Count"});
        return model;
    }
    
    //Admin Panel -> Pending Approval Table
    public DefaultTableModel getAdminMainMenuTableModel(ArrayList<Department> inputList){
        Object[][] table=new Object[inputList.size()][];
        int rowId=0;
        for(Department d: inputList) {
            table[rowId++]=new Object[]{d.getEmployee_no(), d.getFirst_name(), d.getLast_name(), d.getGender(),  d.getDeparment_name(),  d.getTitle()};
        }
        DefaultTableModel model = new DefaultTableModel(table, new Object[]{"Employee No.", "First Name", "Last Name", "Gender", "Department","Job Title"});
        return model;
    }
    
    public Date dateControl(Integer numOfYear){
        Calendar c= Calendar.getInstance();
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");        
        sb.append(c.get(Calendar.YEAR)-numOfYear); //Current Year -16
        sb.append("-");
        sb.append(c.get(Calendar.MONTH)); //Current Month
        sb.append("-");
        sb.append(c.get(Calendar.DAY_OF_MONTH));// Current Day
        try{
            return dateFormat.parse(sb.toString());            
        }catch(ParseException e){
            System.out.println("Date parse Error");
            return null;
        }        
    }
    
     public void cleanComboBox(JComboBox targetComboBox){
         for(int i=targetComboBox.getItemCount()-1;i>0;i--)targetComboBox.removeItemAt(i);
     }
     
     public void cleanTableModel(JTable targetTable){
         DefaultTableModel model = (DefaultTableModel) targetTable.getModel();
         model.setRowCount(0);    
     }
     
     
}








































































































































