/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.dao;

import com.empsystem.entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Michael
 */
public class Login {
    protected Connection conn;
    protected ResultSet rs;
    protected PreparedStatement pstmt;
    private String query;
    
    public Employee login(String username, String password) {       
        Database db = new Database();
        Employee loginEmployee=null;       
        if(db.connect()){
           conn = db.getConnection();    
           query = "SELECT login_info.emp_no, username, password, birth_date, first_name, last_name, gender, hire_date,  departments.dept_no, dept_name , dept_emp.from_date AS dept_from_date,dept_emp.to_date AS dept_to_date, title, titles.from_date AS title_from_date, titles.to_date AS title_to_date,login_info.status\n" +
                    "FROM login_info\n" +
                    "LEFT JOIN employees ON login_info.emp_no = employees.emp_no\n" +
                    "LEFT JOIN dept_emp ON login_info.emp_no = dept_emp.emp_no\n" +
                    "LEFT JOIN departments ON dept_emp.dept_no = departments.dept_no\n" +
                    "LEFT JOIN titles ON login_info.emp_no = titles.emp_no\n" +
                    "WHERE titles.to_date > current_timestamp() \n" +
                    "AND dept_emp.to_date > current_timestamp()\n" +
                    "AND login_info.status='valid'\n"+
                    "AND binary(username)=? AND binary(password)=?;"; // MySql is not case sensitive                    
            try{                
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                
                rs=pstmt.executeQuery();
                
                if(rs.next()){                   
                    System.out.println(username + " Login Succed " );
                    loginEmployee = new Employee(rs.getInt("emp_no"),rs.getString("first_name"),rs.getString("last_name"),rs.getDate("birth_date"),
                                                rs.getString("gender"),rs.getDate("hire_date"),rs.getString("title"),rs.getDate("title_from_date"),
                                                rs.getDate("title_to_date"),rs.getString("dept_no"),rs.getString("dept_name"),rs.getDate("dept_from_date"),
                                                rs.getDate("dept_to_date"),rs.getString("username"),rs.getString("password"),rs.getString("login_info.status"));
                }else{
                    System.out.println("Login Fail username/password invalid");                    
                }
                pstmt.close();
                rs.close();
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
        return loginEmployee;
    }
}












