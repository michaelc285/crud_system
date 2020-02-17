package com.empsystem.dao;

import com.empsystem.entity.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import com.empsystem.entity.SearchSelection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class DepartmentDaoImpl implements DepartmentDao {
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pstmt;
    private Statement stmt;
    private String query ;

    
    
    //Member list 
    //emp_no, first_name, last_name, gender, hire_date, title, dept_no, dept_name, from_date, to_date
    @Override
    public ArrayList<Department> underYourDeptList() {
       
        Database db = new Database();
        ArrayList<Department> deptEmpList = new ArrayList<>();
        if(db.connect()){            
            conn = db.getConnection();
            query = "SELECT departments.dept_no, dept_name, employees.emp_no, dept_emp.from_date, dept_emp.to_date, first_name, last_name, gender, hire_date, title FROM departments "+
                    "LEFT JOIN dept_emp ON dept_emp.dept_no = departments.dept_no "+ 
                    "LEFT JOIN employees ON dept_emp.emp_no = employees.emp_no " + 
                    "LEFT JOIN titles ON titles.emp_no = employees.emp_no " +
                    "WHERE dept_emp.to_date > current_timestamp() " + 
                    "and titles.to_date >current_timestamp();";     
            try{
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);
                
                Department employee;
                while(rs.next()){
                    // super(employee_no, first_name, last_name, gender, hire_date, title, department_no, deparment_name, department_from_date, department_to_date);
                    //employee = new Department(,null,null,null,null,null,null,null,null,null); 
                    employee = new Department(rs.getInt("emp_no"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("gender"),rs.getDate("hire_date"),rs.getString("title"),
                                          rs.getString("dept_no"),rs.getString("dept_name"),rs.getDate("from_date"),rs.getDate("to_date"));
                    deptEmpList.add(employee);                    
                } 
            conn.close();
            rs.close();
            stmt.close();                
            } catch (SQLException e) {
            e.printStackTrace();
            
            }catch(Exception e){
            e.printStackTrace();
            }finally{
                try{
                    if(stmt!=null) stmt.close();
                }catch(SQLException se2){}
                
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }   
            } 
        }    
        return deptEmpList;
    }
    
    // Department members list with attribute
    //emp_no, first_name, last_name, gender, hire_date, title, from_date, to_date, current_partake_no, total_partake_no
    /**
     * ALL, Job Title, Employee Name, Employee ID, No Job
     * @param department_number
     * @param selection
     * @param searchValue
     * @return 
     */
    @Override
    public  ArrayList<Department> departmentMembersList(String department_number, SearchSelection selection, String searchValue) {
        Database db = new Database();  
        ArrayList<Department> deptEmpList = new ArrayList<>();
        String inputValue="%"+searchValue+"%";
        Department member;
        String extraQuery;        
        switch(selection){
            case JOB_TITLE:
                extraQuery=" AND title LIKE ?";
                break;
            case EMPLOYEE_FULL_NAME:
                extraQuery=" AND concat(first_name,' ', last_name) LIKE ?";
                break;
            case EMPLOYEE_NUMBER:
                extraQuery= " AND emp_no LIKE  ?";
                break;
            case CURRENT_PARTAKE_JOB_LESS_AND_EQUAL:
                extraQuery=" AND current_job_partake <= ? ORDER BY current_job_partake ";                
                inputValue=searchValue;
                break;
            case TOTAL_PARTAKE_JOB_LESS_AND_EQUAL:
                extraQuery=" AND total_job_partake <= ? ORDER BY total_job_partake ";
                inputValue=searchValue;
                break;
            case CURRENT_PARTAKE_JOB_GREATER_AND_EQUAL:
                extraQuery=" AND current_job_partake >= ?  ORDER BY current_job_partake DESC ";
                inputValue=searchValue;
                break;
            case TOTAL_PARTAKE_JOB_GREATER_AND_EQUAL:
                extraQuery=" AND total_job_partake >= ? ORDER BY total_job_partake DESC";
                inputValue=searchValue;
                break;
            default:
                extraQuery="";
                break;
        }       
        if(db.connect()){   
            conn = db.getConnection();
            query = "SELECT * \n" +
                    "FROM (SELECT departments.dept_no, dept_name, dept_emp.from_date, dept_emp.to_date, employees.emp_no, first_name,last_name,gender, hire_date, title , IFNULL(a.current_job_partake, 0) AS current_job_partake,  IFNULL(b.total_job_partake, 0) AS total_job_partake\n" +
                            "FROM employees\n" +
                            "LEFT JOIN dept_emp ON employees.emp_no = dept_emp.emp_no\n" +
                            "LEFT JOIN titles ON employees.emp_no = titles.emp_no \n" +
                            "LEFT JOIN departments ON dept_emp.dept_no = departments.dept_no\n" +
                            "LEFT JOIN (SELECT emp_no, count(emp_no) AS current_job_partake\n" +
                                        "FROM project_partake\n" +
                                        "LEFT JOIN project ON project_partake.project_id=project.project_id\n" +
                                        "WHERE project.duration IS NULL\n"+
                                        "GROUP BY emp_no) AS a ON a.emp_no=employees.emp_no\n" +
                            "LEFT JOIN(SELECT emp_no, count(emp_no) as total_job_partake\n" +
                                        "FROM project\n" +
                                        "RIGHT JOIN project_partake ON project_partake.project_id = project.project_id\n" +
                                        "GROUP BY emp_no) AS b ON b.emp_no=employees.emp_no\n" +
                            "WHERE dept_emp.to_date > current_timestamp() \n" +
                            "AND titles.to_date > current_timestamp()) as result\n" +
                    "WHERE dept_no= ? ";
            try{
                pstmt=conn.prepareStatement(query.concat(extraQuery));
                pstmt.setString(1, department_number);
                if(!extraQuery.equals(""))pstmt.setString(2,inputValue);
                rs = pstmt.executeQuery();

                    while(rs.next()){
                            member = new Department(rs.getInt("emp_no"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"), 
                                                                    rs.getDate("hire_date"), rs.getString("title"), rs.getDate("from_date"),rs.getDate("to_date"),
                                                                    rs.getInt("current_job_partake"), rs.getInt("total_job_partake"));                                          
                            deptEmpList.add(member);
                        }                                       
            conn.close();
            rs.close();
            pstmt.close();              
            } catch (SQLException e) {
            e.printStackTrace();         
            }catch(Exception e){
            e.printStackTrace();
            }finally{
                try{
                    if(pstmt!=null) pstmt.close();
                }catch(SQLException se2){}              
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }   
            } 
        }    
        return deptEmpList;
    }

    // Employee currently task partake number
    @Override
    public HashMap<Integer, Integer> currentPartakeCount() {
        Database db = new Database();
        HashMap<Integer, Integer> currentPartakeCountMap = new HashMap<>();       
        if(db.connect()){            
            conn = db.getConnection();         
            query = "SELECT emp_no, Count(emp_no) AS currentPartake " +
                        "FROM project_partake " +
                        "LEFT JOIN project ON project_partake.project_id = project.project_id " +
                        "WHERE duration IS NULL " +
                        "GROUP BY emp_no;";             
            try{
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);              
                while(rs.next()){
                    currentPartakeCountMap.put(rs.getInt("emp_no"),rs.getInt("currentPartake"));
                }              
            conn.close();
            rs.close();
            stmt.close();
                
            } catch (SQLException e) {
            e.printStackTrace();
            
            }catch(Exception e){
            e.printStackTrace();
            }finally{
                try{
                    if(stmt!=null) stmt.close();
                }catch(SQLException se2){}
                
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }   
            } 
        }    
        return currentPartakeCountMap;
    }
    
    
    // Total project number of employee partaked
    @Override
    public HashMap<Integer, Integer> totalPartakeCount() {
        Database db = new Database();
        HashMap<Integer, Integer> totalPartakeCountMap = new HashMap<>();       
        if(db.connect()){          
            conn = db.getConnection();        
            query = "SELECT emp_no, Count(emp_no) AS totalPartake " +
                    "FROM project_partake " +
                    "LEFT JOIN project ON project_partake.project_id = project.project_id " +                        
                    "GROUP BY emp_no;" ;                 
            try{
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);             
                
                while(rs.next()){
                    totalPartakeCountMap.put(rs.getInt("emp_no"), rs.getInt("totalPartake"));
                }             
            conn.close();
            rs.close();
            stmt.close();             
            } catch (SQLException e) {
            e.printStackTrace();
            
            }catch(Exception e){
            e.printStackTrace();
            }finally{
                try{
                    if(stmt!=null) stmt.close();
                }catch(SQLException se2){}
                
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }   
            } 
        }    
        return totalPartakeCountMap;
    }
    
    // Get employees latest title
    @Override
    public HashMap<Integer, Department> employeeHighTitle() {
        Database db = new Database();      
        HashMap<Integer, Department> titleList = new HashMap<>();      
        if(db.connect()){   
            conn = db.getConnection();
            query = "SELECT * FROM employees.titles WHERE to_date>=current_timestamp();";                    
            try{
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);                
                Department member;               
                while(rs.next()){                        
                        member = new Department(rs.getInt("emp_no"), rs.getString("title"));
                        titleList.put(rs.getInt("emp_no"),member);
                    }                           
            conn.close();
            rs.close();
            stmt.close();
                
            } catch (SQLException e) {
            e.printStackTrace();
            
            }catch(Exception e){
            e.printStackTrace();
            }finally{
                try{
                    if(stmt!=null) stmt.close();
                }catch(SQLException se2){}
                
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }   
            } 
        }    
        return titleList;
    }
    
    @Override
    public ArrayList<Department> getDepartmentList() {
        ArrayList<Department> departmentList = new ArrayList<>();
        Database db = new Database();
        
        if(db.connect()){
           conn = db.getConnection();    
           query = "SELECT * FROM departments WHERE dept_no != 'd000' ORDER BY dept_no";                   
            try{                
                pstmt = conn.prepareStatement(query);                
                rs = pstmt.executeQuery();
                while(rs.next()){
                    departmentList.add(new Department(rs.getString("dept_no"),rs.getString("dept_name")));                    
                }                         
                pstmt.close();
                rs.close();
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();           
            }catch(Exception e){
                e.printStackTrace();
            }finally{        
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }   
            } 
        }    
        return departmentList;        
    }

    @Override
    public ArrayList<Department> employeeInvalidAccount(SearchSelection selection, String searchValue) {
        ArrayList<Department> departmentList=new ArrayList<>();
        Database db = new Database();
        String extraQuery;
        
        switch(selection){
            case EMPLOYEE_FULL_NAME:
                extraQuery=" AND concat(first_name, ' ', last_name) LIKE ?;";
                break;
            case EMPLOYEE_NUMBER:
                extraQuery=" AND employees.emp_no LIKE ?;";
                break;
            case DEPARTMENT_NAME:
                extraQuery=" AND dept_name LIKE ?;";
                break;
            case DEPARTMENT_NUMBER:
                extraQuery=" AND dept_emp.dept_no LIKE ?;";
                break;
            case JOB_TITLE:
                extraQuery=" AND title LIKE ?;";
                break;
            default:    
                extraQuery="";
                searchValue=null;
                break;
        }       
        
        if(db.connect()){
           conn = db.getConnection();    
           query =  "SELECT employees.emp_no, first_name, last_name, gender, dept_name, title, status " +
                    "FROM employees.login_info " +
                    "LEFT JOIN employees ON employees.emp_no=login_info.emp_no " +
                    "LEFT JOIN titles ON titles.emp_no=login_info.emp_no " +
                    "LEFT JOIN dept_emp ON dept_emp.emp_no=login_info.emp_no " +
                    "LEFT JOIN departments ON departments.dept_no=dept_emp.dept_no " +
                    "WHERE dept_emp.to_date>=current_timestamp() AND status= 'invalid' ";
                   
            try{                
                pstmt = conn.prepareStatement(query.concat(extraQuery));
                if(searchValue!=null)pstmt.setString(1, "%"+searchValue+"%");
                rs = pstmt.executeQuery();
                while(rs.next()){
                    departmentList.add(new Department(rs.getInt("emp_no"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("gender"),rs.getString("dept_name"),rs.getString("title"),rs.getString("status")));                    
                }                         
                pstmt.close();
                rs.close();
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();           
            }catch(Exception e){
                e.printStackTrace();
            }finally{        
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }   
            } 
        }    
        return departmentList;    
    }

    @Override
    public ArrayList<Department> currentEmployeesList(SearchSelection selection, String searchValue) {
        ArrayList<Department> departmentList=new ArrayList<>();
        Database db = new Database();
        String extraQuery;
        
        switch(selection){
            case EMPLOYEE_FULL_NAME:
                extraQuery=" AND concat(first_name, ' ', last_name) LIKE ?;";
                break;
            case EMPLOYEE_NUMBER:
                extraQuery=" AND employees.emp_no LIKE ?;";
                break;
            case DEPARTMENT_NAME:
                extraQuery=" AND dept_name LIKE ?;";
                break;
            case DEPARTMENT_NUMBER:
                extraQuery=" AND dept_emp.dept_no LIKE ?;";
                break;
            case JOB_TITLE:
                extraQuery=" AND title LIKE ?;";
                break;
            default:    
                extraQuery="";
                searchValue=null;
                break;
        }       
        
        if(db.connect()){
           conn = db.getConnection();    
           query =  "SELECT employees.emp_no, first_name, last_name, gender, dept_name, title, status " +
                    "FROM employees.login_info " +
                    "LEFT JOIN employees ON employees.emp_no=login_info.emp_no " +
                    "LEFT JOIN titles ON titles.emp_no=login_info.emp_no " +
                    "LEFT JOIN dept_emp ON dept_emp.emp_no=login_info.emp_no " +
                    "LEFT JOIN departments ON departments.dept_no=dept_emp.dept_no " +
                    "WHERE dept_emp.to_date>=current_timestamp() "+
                    "AND employees.emp_no != 1001";
                    
                   
            try{                
                pstmt = conn.prepareStatement(query.concat(extraQuery));
                if(searchValue!=null)pstmt.setString(1, "%"+searchValue+"%");
                rs = pstmt.executeQuery();
                while(rs.next()){
                    departmentList.add(new Department(rs.getInt("emp_no"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("gender"),rs.getString("dept_name"),rs.getString("title"),rs.getString("status")));                    
                }                         
                pstmt.close();
                rs.close();
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();           
            }catch(Exception e){
                e.printStackTrace();
            }finally{        
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }   
            } 
        }    
        return departmentList;
    }
}
    





































































































































































































