/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.entity;


import java.util.Date;

/**
 * 
 * @author Michael
 */

public class Employee {
    protected Integer employee_no;
    protected String first_name;
    protected String last_name;
    protected Date birth_date;
    protected String gender;
    protected Date hire_date;
    protected String title;
    protected Date title_from_date;
    protected Date title_to_date;
    protected String department_no;
    protected String department_name;
    protected Date department_from_date;
    protected Date department_to_date;
    protected String username;
    protected String password;
    protected Integer current_partake_count;
    protected Integer total_partake_count;
    protected String accountValidationStatus;
    
    public Employee(Integer employee_no, String first_name, String last_name, Date birth_date, String gender, Date hire_date, String title, Date title_from_date, Date title_to_date, String department_no, String deparment_name, Date department_from_date, Date department_to_date, String username, String password, Integer current_partake_count, Integer total_partake_count, String accountValidation) {
        this.employee_no = employee_no;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.hire_date = hire_date;
        this.title = title;
        this.title_from_date = title_from_date;
        this.title_to_date = title_to_date;
        this.department_no = department_no;
        this.department_name = deparment_name;
        this.department_from_date = department_from_date;
        this.department_to_date = department_to_date;
        this.username = username;
        this.password = password;
        this.current_partake_count = current_partake_count;
        this.total_partake_count = total_partake_count;
        this.accountValidationStatus = accountValidation;
    }
  

    public Employee(Integer employee_no, String first_name, String last_name, Date birth_date, String gender, Date hire_date, String title, Date title_from_date, Date title_to_date, String department_no, String deparment_name, Date department_from_date, Date department_to_date, Integer salary, Date salary_from_date, Date salary_to_date, String username, String password) {
        this.employee_no = employee_no;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.hire_date = hire_date;
        this.title = title;
        this.title_from_date = title_from_date;
        this.title_to_date = title_to_date;
        this.department_no = department_no;
        this.department_name = deparment_name;
        this.department_from_date = department_from_date;
        this.department_to_date = department_to_date;
        this.username = username;
        this.password = password;
    }

    public Employee(Integer employee_no, String first_name, String last_name, String gender, Date hire_date, String title, String department_no, String deparment_name, Date department_from_date, Date department_to_date) {
        this.employee_no = employee_no;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.hire_date = hire_date;
        this.title = title;
        this.department_no = department_no;
        this.department_name = deparment_name;
        this.department_from_date = department_from_date;
        this.department_to_date = department_to_date;
    }

    public Employee(Integer employee_no, String first_name, String last_name, String gender, String title) {
        this.employee_no = employee_no;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.title = title;
    }

    public Employee(Integer employee_no, String first_name, String last_name, String gender, Date hire_date, String title, Date department_from_date, Date department_to_date, Integer current_partake_count, Integer total_partake_count) {
        this.employee_no = employee_no;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.hire_date = hire_date;
        this.title = title;
        this.department_from_date = department_from_date;
        this.department_to_date = department_to_date;
        this.current_partake_count = current_partake_count;
        this.total_partake_count = total_partake_count;
    }
    
    //Login Panel Use
    public Employee(Integer employee_no, String first_name, String last_name, Date birth_date, String gender, Date hire_date, String title, Date title_from_date, Date title_to_date, String department_no, String deparment_name, Date department_from_date, Date department_to_date, String username, String password, String accountValidation) {
        this.employee_no = employee_no;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.hire_date = hire_date;
        this.title = title;
        this.title_from_date = title_from_date;
        this.title_to_date = title_to_date;
        this.department_no = department_no;
        this.department_name = deparment_name;
        this.department_from_date = department_from_date;
        this.department_to_date = department_to_date;
        this.username = username;
        this.password = password;
        this.accountValidationStatus = accountValidation;
    }

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }
      
    public Employee(Integer employee_no, String title) {
        this.employee_no = employee_no;
        this.title = title;
    }

    public Employee() {
    }

    
    
    
    
    public Integer getCurrent_partake_count() {
        return current_partake_count;
    }

    public void setCurrent_partake_count(Integer current_partake_count) {
        this.current_partake_count = current_partake_count;
    }

    public Integer getTotal_partake_count() {
        return total_partake_count;
    }

    public void setTotal_partake_count(Integer total_partake_count) {
        this.total_partake_count = total_partake_count;
    }

   

    public Integer getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(Integer employee_no) {
        this.employee_no = employee_no;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTitle_from_date() {
        return title_from_date;
    }

    public void setTitle_from_date(Date title_from_date) {
        this.title_from_date = title_from_date;
    }

    public Date getTitle_to_date() {
        return title_to_date;
    }

    public void setTitle_to_date(Date title_to_date) {
        this.title_to_date = title_to_date;
    }

    public String getDepartment_no() {
        return department_no;
    }

    public void setDepartment_no(String department_no) {
        this.department_no = department_no;
    }

    public String getDeparment_name() {
        return department_name;
    }

    public void setDeparment_name(String deparment_name) {
        this.department_name = deparment_name;
    }

    public Date getDepartment_from_date() {
        return department_from_date;
    }

    public void setDepartment_from_date(Date department_from_date) {
        this.department_from_date = department_from_date;
    }

    public Date getDepartment_to_date() {
        return department_to_date;
    }

    public void setDepartment_to_date(Date department_to_date) {
        this.department_to_date = department_to_date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountValidation() {
        return accountValidationStatus;
    }

    public void setAccountValidation(String accountValidation) {
        this.accountValidationStatus = accountValidation;
    }

    @Override
    public String toString() {
        return "Employee{" + "employee_no=" + employee_no + ", first_name=" + first_name + ", last_name=" + last_name + ", birth_date=" + birth_date + ", gender=" + gender + ", hire_date=" + hire_date + ", title=" + title + ", title_from_date=" + title_from_date + ", title_to_date=" + title_to_date + ", department_no=" + department_no + ", deparment_name=" + department_name + ", department_from_date=" + department_from_date + ", department_to_date=" + department_to_date + ", username=" + username + ", password=" + password + ", current_partake_count=" + current_partake_count + ", total_partake_count=" + total_partake_count + ", accountValidation=" + accountValidationStatus + '}';
    }
    
}















