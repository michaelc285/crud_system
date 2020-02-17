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
public class Department extends Employee {
        
    
    public Department(Integer employee_no, String first_name, String last_name, String gender, Date hire_date, String title, String department_no, String deparment_name, Date department_from_date, Date department_to_date) {
        super(employee_no, first_name, last_name, gender, hire_date, title, department_no, deparment_name, department_from_date, department_to_date);
    }

    public Department(Integer employee_no, String first_name, String last_name, String gender, Date hire_date, String title, Date department_from_date, Date department_to_date, Integer current_partake_count, Integer total_partake_count) {
        super(employee_no, first_name, last_name, gender, hire_date, title, department_from_date, department_to_date, current_partake_count, total_partake_count);
    }

    public Department(Integer employee_no, String title) {
        super(employee_no, title);
    }

    public Department(String department_no, String department_name){
        super.department_no=department_no;
        super.department_name=department_name;
    }
    
    public Department(Integer emp_no, String first_name, String last_name, String gender, String department_name, String title, String accountValidationStatus){
        super.employee_no=emp_no;
        super.first_name=first_name;
        super.last_name=last_name;
        super.gender=gender;
        super.department_name=department_name;
        super.title=title;
        super.accountValidationStatus=accountValidationStatus;
    }
}







