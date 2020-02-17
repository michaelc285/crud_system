/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.dao;

import com.empsystem.entity.AccountStatus;
import com.empsystem.entity.Employee;
import com.empsystem.entity.SearchSelection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.regex.Pattern;
import com.empsystem.util.Converter;
/**
 *
 * @author Michael
 */
public class EmployeeDaoImpl implements EmployeeDao{

    protected Connection conn;
    protected ResultSet rs;
    protected PreparedStatement pstmt;
    protected Employee loginEmployee;
    private String query;

    @Override
    public boolean passwordPattern(String password) {
        Pattern specailCharPattern = Pattern.compile("[^a-z0-9!@#$%^&*]", Pattern.CASE_INSENSITIVE);
        Pattern upperCasePattern = Pattern.compile("[A-Z ]");
        Pattern lowerCasePattern = Pattern.compile("[a-z ]");
        Pattern digitCasePattern = Pattern.compile("[0-9 ]");
        int maxLength = 16;
        int minLength = 6;
        boolean flag = true;
        
        if(password.length()<minLength || password.length()>maxLength){ //password length 6-16
            System.out.println("Password Length should be at least 6 and no greather than 16:  " + password.length());
            flag=false;
        } 
        
        if (!upperCasePattern.matcher(password).find()){
            System.out.println("Password must have atleast one uppercase character");
            flag=false;
        }
        
        if(!lowerCasePattern.matcher(password).find()){
            System.out.println("Password must have atleast one lowercase character");
            flag=false;
        }
        
        if(!digitCasePattern.matcher(password).find()){
            System.out.println("Password must have atleast one digit character");
            flag=false;
        }
        
        if(specailCharPattern.matcher(password).find()){
            System.out.println("Password only accept a-z, 0-9, !@#$%^&*");
            flag=false;
        }
        
        return flag;
    }
    
    @Override
    public boolean passwordDoubleValidation(String password, String rePassword) {
        return password.equals(rePassword);
    }

    @Override
    public boolean changePassword(String username, String newPassword) {
        boolean flag = false;         
        Database db = new Database();
              
        if(db.connect()){
           conn = db.getConnection();    
           query = "UPDATE login_info " +
                    "SET password= ? " +
                    "WHERE BINARY(username) = ?;";                    
            try{                
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, newPassword);
                pstmt.setString(2, username);                             
                
                int i = pstmt.executeUpdate();
                
                if(i>0){
                    System.out.println("Password Update succeed");
                    flag=true;
                }            
                pstmt.close();
                conn.close();                
            } catch (SQLException e) {
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
        return flag;
    }

    @Override
    public Integer getLastEmployeeNo() {
        Database db = new Database();
        if(db.connect()){
            conn = db.getConnection();
            query="SELECT MAX(emp_no) AS emp_no FROM employees.dept_emp;";
            try{
                pstmt=conn.prepareStatement(query);
                rs=pstmt.executeQuery();
                if(rs.next()){
                    return rs.getInt("emp_no");
                }
            }catch(SQLException e){
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
        return null;
    }

    @Override
    public boolean createEmployee(Integer emp_no, String firstName, String lastName, String gender, Date birthDate, Date hire_date) {
        Database db = new Database();
        boolean flag = false;
        
        if(db.connect()){
           conn = db.getConnection();    
           try{
                query = "INSERT INTO employees(emp_no,first_name, last_name, gender, birth_date, hire_date) VALUES(?,?,?,?,?,?); "; //1,2,3,4,5,6
                pstmt = conn.prepareStatement(query);
                
                pstmt.setInt(1, emp_no);
                pstmt.setString(2, firstName);
                pstmt.setString(3, lastName);
                pstmt.setString(4,gender);
                pstmt.setDate(5, new java.sql.Date(birthDate.getTime()));
                pstmt.setDate(6, new java.sql.Date(hire_date.getTime()));
                               
                int i = pstmt.executeUpdate();               
                if(i>0){
                    flag=true;
                    System.out.println("Emplyoee Created");
                }               
                pstmt.close();
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
        return flag;
    }

    @Override
    public boolean createDeptEmployee(Integer emp_no, String department, Date from_date) {
        Database db = new Database();
        boolean flag = false;
        if(db.connect()){
           conn = db.getConnection();                                                    
            try{
                query = "INSERT INTO dept_emp(emp_no, dept_no, from_date, to_date) VALUES(?,?,?,'9999-01-01');";
                pstmt = conn.prepareStatement(query);
                
                pstmt.setInt(1,emp_no);
                pstmt.setString(2, department);
                pstmt.setDate(3, new java.sql.Date(from_date.getTime()));

                int i = pstmt.executeUpdate();               
                if(i>0){
                    flag=true;
                    System.out.println("Department Employee created");
                }                
                pstmt.close();
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
        return flag;
    }

    @Override
    public boolean createDeptManager(Integer emp_no, String department,Date from_date) {
        Database db = new Database();
        boolean flag = false;
        if(db.connect()){
           conn = db.getConnection();    
           try{
                query = "INSERT INTO dept_manager(emp_no, dept_no, from_date, to_date) VALUES(?,?,?,'9999-01-01')";
                pstmt = conn.prepareStatement(query);
                
                pstmt.setInt(1,emp_no);
                pstmt.setString(2, department);
                pstmt.setDate(3, new java.sql.Date(from_date.getTime()));

                int i = pstmt.executeUpdate();               
                if(i>0){
                    flag=true;
                    System.out.println("Department Manager created");
                }                
                pstmt.close();
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
        return flag;
    }

    @Override
    public boolean createEmployeeTitle(Integer emp_no, String title, Date from_date) {
        Database db = new Database();
        boolean flag = false;
        
        if(db.connect()){
           conn = db.getConnection();    
            try{
                query = "INSERT INTO titles(emp_no, title, from_date,to_date)VALUES(?,?,?,'9999-01-01');";
                pstmt = conn.prepareStatement(query);
                
                pstmt.setInt(1,emp_no);
                pstmt.setString(2, title);
                pstmt.setDate(3, new java.sql.Date(from_date.getTime()));

                int i = pstmt.executeUpdate();               
                if(i>0){
                    flag=true;
                    System.out.println("Employee's Title created");
                }                
                pstmt.close();
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
        return flag;
    }

    @Override
    public boolean createLoginInfo(Integer emp_no, String username, String password, String status) {
        Database db = new Database();
        boolean flag = false;
        
        if(db.connect()){
           conn = db.getConnection();    
           query = "INSERT INTO login_info(emp_no, username, password, status)VALUES(?,?,?,?);";       
            
            try{                
                pstmt = conn.prepareStatement(query);
                
                pstmt.setInt(1, emp_no);
                pstmt.setString(2, username);
                pstmt.setString(3,password);
                pstmt.setString(4, status);

                int i = pstmt.executeUpdate();               
                if(i>0){
                    flag=true;
                    System.out.println("Employee's Login Info created");
                }                
                pstmt.close();
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
        return flag;
    }

    @Override
    public boolean registry(String username, String firstName, String lastName, String gender, Date birthDate, String department, String jobTitle, String defaultPassword, AccountStatus defaultStatus) {
           Integer emp_no = getLastEmployeeNo()+1;        
           Date hire_date = new Date();
           Date from_date = new Date();
           boolean flag=false;
      
           boolean stepOne=createEmployee(emp_no, firstName, lastName, gender, birthDate, hire_date);
           boolean stepTwo=createDeptEmployee(emp_no, department, from_date);
           boolean stepThree=createEmployeeTitle(emp_no,jobTitle,from_date);
           boolean stepFour=createLoginInfo(emp_no, username, defaultPassword, Converter.statusToString(defaultStatus));
           
           if(jobTitle.equals("Manager")){
               boolean stepFive=createDeptManager(emp_no, department, from_date);
               if(stepOne && stepTwo && stepThree && stepFour && stepFive) flag=true;
               System.out.println("Manager register complete");
               return flag;
           }else{
               if(stepOne && stepTwo && stepThree && stepFour) flag=true;
               System.out.println("Non-Manager Staff registration complete");
               return flag;      
           }             
    }

    @Override
    public boolean checkUsername(String username) {
        Database db = new Database();
        boolean flag = false;
        
        if(db.connect()){
            conn = db.getConnection();           
            try{
                query = "SELECT username FROM employees.login_info WHERE binary(username) = ?;";
                pstmt = conn.prepareStatement(query);
                
                pstmt.setString(1, username);
                
                rs = pstmt.executeQuery();
                                
                if(rs.next()){
                    System.out.println("Username already exisit, Please try again !!");                    
                }else{
                    flag=true;
                    System.out.println("No duplicate username exisit");
                }                
                pstmt.close();
                conn.close();
                rs.close();
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
        return flag;
    }

    @Override
    public boolean usernamePattern(String username) {
        Pattern specailCharPattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
        Pattern startWithCharPattern = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);
 
        int maxLength = 16;
        int minLength = 8;
        boolean flag = true;
        
        if(username.length()<minLength || username.length()>maxLength){ //password length 6-16
            System.out.println("Username Length should be at least 8 and no greather than 16:  " + username.length());
            flag=false;
        } 
        
        if (specailCharPattern.matcher(username).find()){
            System.out.println("Username only accept a-z, A-z, 0-9");
            flag=false;
        }
        
        if(username.length()>0 && !startWithCharPattern.matcher(username.substring(0, 1)).find()){
            System.out.println("Username must start with character");
            flag=false;
        }
        
        return flag;
    
    }
    
    @Override
    public boolean namePattern(String name){
        Pattern specailCharPattern = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
        int maxLength = 32;
        int minLength = 1;
        boolean flag = true;
        
        if(name.length()<minLength || name.length()>maxLength){ //password length 6-16
            System.out.println("Name Length should be at least 1 and no greather than 32:  " + name.length());
            flag=false;
        } 
        
        if (specailCharPattern.matcher(name).find()){
            System.out.println("Name can only contain english letter");
            flag=false;
        }
  
        return flag;
    }

    @Override
    public boolean checkEmployeeID(Integer emp_no, String dept_no) {
        Database db = new Database();
        boolean flag = false;
        
        if(db.connect()){
            conn = db.getConnection();           
            try{
                query = "SELECT employees.emp_no, dept_no \n" +
                        "FROM employees.employees \n" +
                        "LEFT JOIN dept_emp ON dept_emp.emp_no=employees.emp_no\n" +
                        "WHERE employees.emp_no=? AND dept_no=?;";
                pstmt = conn.prepareStatement(query);
                
                pstmt.setInt(1, emp_no);
                pstmt.setString(2, dept_no);
                
                rs = pstmt.executeQuery();
                                
                if(rs.next()){
                    System.out.println("Employee ID: "+emp_no+" exisit");
                    flag=true;                      
                }else{                    
                    System.out.println("There are no Employee ID: " + emp_no+" in Department: " +dept_no);
                }                
                pstmt.close();
                conn.close();
                rs.close();
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
        return flag;
    }

    @Override
    public void accountActivator(Integer emp_no, AccountStatus status) {
        Database db = new Database();
        
        if(db.connect()){
            conn = db.getConnection();           
            try{
                query = "UPDATE login_info SET status=? WHERE emp_no=?;";
                pstmt = conn.prepareStatement(query);                
                pstmt.setString(1, Converter.statusToString(status));
                pstmt.setInt(2, emp_no);
                int i =pstmt.executeUpdate();
                               
                if(i>0){
                    if(status==AccountStatus.Valid){
                        System.out.println("Employee ID: "+emp_no+" activation success"); 
                    }else{
                        System.out.println("Employee ID: "+emp_no+" deactivation success"); 
                    }                                                          
                }else{                    
                    System.out.println("Action Failed, There are no Employee ID: " + emp_no );
                }                
                pstmt.close();
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
    }

    @Override
    public void revokeEmployee(Integer revokeEmpNumber) {
        Database db=new Database();
        if(db.connect()){
            conn=db.getConnection();
            query="UPDATE dept_emp\n" +
                  "SET to_date=current_date()\n" +
                  "WHERE emp_no = ?;";
            try{
                pstmt=conn.prepareStatement(query);
                pstmt.setInt(1,revokeEmpNumber);
                int i = pstmt.executeUpdate();
                if(i>0){
                    System.out.println("Emplyoee: "+revokeEmpNumber+" Expiry date updated");
                }
            }catch(SQLException e) {
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
    }

    @Override
    public void revokeManagerGrade(Integer revokeManagerEmpNumber) {
        Database db=new Database();
        if(db.connect()){
            conn=db.getConnection();
            query="UPDATE dept_manager\n" +
                  "SET to_date=current_date()\n" +
                  "WHERE emp_no = ?;";
            try{
                pstmt=conn.prepareStatement(query);
                pstmt.setInt(1,revokeManagerEmpNumber);
                int i = pstmt.executeUpdate();
                if(i>0){
                    System.out.println("Manager : " +revokeManagerEmpNumber+ " Expiry date updated");
                }
            }catch(SQLException e) {
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
    }

    @Override
    public void revokeAccount(Integer emp_no) {
        Database db=new Database();
        if(db.connect()){
            conn=db.getConnection();
            query="UPDATE login_info\n" +
                  "SET status='invalid'\n" +
                  "WHERE emp_no = ?;";
            try{
                pstmt=conn.prepareStatement(query);
                pstmt.setInt(1,emp_no);
                int i = pstmt.executeUpdate();
                if(i>0){
                    System.out.println("Account of Employee: " +emp_no+ " Expiry date updated");
                }
            }catch(SQLException e) {
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
    }
    
        @Override
    public void revokeTitle(Integer emp_no) {
        Database db=new Database();
        if(db.connect()){
            conn=db.getConnection();
            query="UPDATE titles\n" +
                  "SET to_date=current_date()\n" +
                  "WHERE emp_no = ?;";
            try{
                pstmt=conn.prepareStatement(query);
                pstmt.setInt(1,emp_no);
                int i = pstmt.executeUpdate();
                if(i>0){
                    System.out.println("Title of Employee: " +emp_no+ " Expiry date updated");
                }
            }catch(SQLException e) {
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
    }
}




















































































































































































































































































