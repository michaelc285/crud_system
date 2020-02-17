/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.dao;

import com.empsystem.entity.AccountStatus;
import java.util.Date;

/**
 *
 * @author Michael
 */
public interface EmployeeDao {
   boolean passwordPattern(String password); // All
   boolean passwordDoubleValidation(String password, String rePassword); // All
   boolean changePassword(String username, String newPassword); // All
   Integer getLastEmployeeNo(); // Admin
   boolean createEmployee(Integer emp_no, String firstName, String lastName, String gender, Date birthDate, Date hire_date); // Admin
   boolean createDeptEmployee(Integer emp_no, String department,Date from_date);// Admin
   boolean createDeptManager(Integer emp_no, String department,Date from_date);// Admin
   boolean createEmployeeTitle(Integer emp_no, String title, Date from_date);// Admin
   boolean createLoginInfo(Integer emp_no, String username, String password, String status);// Admin
   boolean registry(String username, String firstName, String lastName, String gender, Date birthDate, String department, String jobTitle, String defaultPassword, AccountStatus defaultStatus); // Admin
   boolean usernamePattern(String username); //Admin
   boolean checkUsername(String username);// Admin
   boolean namePattern(String name); // Admin
   boolean checkEmployeeID(Integer emp_no, String dept_no); // Admin
   void accountActivator(Integer emp_no, AccountStatus status);// Admin
   void revokeEmployee(Integer expireEmpNumber);
   void revokeManagerGrade(Integer expireManagerEmpNumber);
   void revokeAccount(Integer emp_no);
   void revokeTitle(Integer emp_no);
}



















































