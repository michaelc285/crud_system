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
import com.empsystem.entity.SearchSelection;
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
    public DefaultTableModel getStaffTaskTableModel(ArrayList<Project> inputList,JTable targetTable){       
        DefaultTableModel model = (DefaultTableModel)targetTable.getModel();        
        inputList.forEach((t) -> {
            model.addRow(new Object[]{t.getProject_id(),t.getTask_id(),t.getProject_name(),t.getProject_leader(),
                                        t.getEmp_no(),t.getStart_date(),t.getEnd_date(),t.getDuration(),t.getTask_description()});
        });              
        return model;
    }
               
    // Project Table -> ManagerMainPanelUI, EditProjectPanelUI
    public DefaultTableModel getProjectTableModel(ArrayList<Project> inputList ,JTable targetTable){
        DefaultTableModel model = (DefaultTableModel)targetTable.getModel();        
        model.setRowCount(0);
        inputList.forEach((p) -> {
            model.addRow(new Object[]{p.getProject_id(), p.getProject_leader(), p.getProject_name(), p.getStart_date(), p.getEnd_date(),
                         p.getDuration(), p.getDescription()});            
        });        
        return model;
    }            
    
    // Manager Paenl -> Edit Task : top right Table
    public DefaultTableModel getProjectMemberTableModel(ArrayList<TableManager> inputList ,JTable targetTable){        
        DefaultTableModel model = (DefaultTableModel)targetTable.getModel();
        inputList.forEach((pm)->{
            model.addRow(new Object[]{ pm.getProject().getProject_id(),pm.getProject().getProject_name(),pm.getProject().getTask_id(),pm.getEmployee().getEmployee_no(),
                                         pm.getEmployee().getFirst_name(),pm.getEmployee().getLast_name(),pm.getEmployee().getTitle(),pm.getEmployee().getGender(),pm.getProject().getTask_description()});
        });
        return model;
    }
    
    // Manager Paenl -> Edit Task : Bottom Table
    public DefaultTableModel getDepartmentMemberTableModel(ArrayList<Department> inputList ,JTable targetTable){
        DefaultTableModel model = (DefaultTableModel)targetTable.getModel();            
        inputList.forEach((dmi) -> {
            model.addRow(new Object[]{dmi.getEmployee_no(),dmi.getTitle(),dmi.getFirst_name(),dmi.getLast_name(),dmi.getDepartment_from_date(),
                dmi.getDepartment_to_date(),dmi.getGender(),dmi.getHire_date(),dmi.getCurrent_partake_count(),
                dmi.getTotal_partake_count()});
        });
        return model;
    }
    
    //Admin Panel -> Pending Approval Table
    public DefaultTableModel getAdminMainMenuTableModel(ArrayList<Department> inputList, JTable targetTable){
        DefaultTableModel model = (DefaultTableModel)targetTable.getModel();
        inputList.forEach((emp) -> {
            model.addRow(new Object[]{emp.getEmployee_no(), emp.getFirst_name(), emp.getLast_name(), emp.getGender(),  emp.getDeparment_name(),  emp.getTitle()});
        });        
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













































































































