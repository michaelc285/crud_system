/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.entity;

/**
 *
 * @author Michael
 */

//Integer project_id, String project_name, Integer task_id , String description
//Integer employee_no, String first_name, String last_name, String gender, String title
public class TableManager {
    private Project project;
    private Employee employee;
    
    public TableManager(Integer project_leader, Integer project_id, String project_name, Integer task_id , String task_description, Integer employee_no, String first_name, String last_name, String gender, String title ){
     //Integer project_id, String project_name, Integer task_id , String description
    //Integer employee_no, String first_name, String last_name, String gender, String title
        
        project = new Project(project_leader ,project_id, project_name,task_id , task_description);
        employee = new Employee(employee_no, first_name,last_name, gender, title);
    }

    public Project getProject() {
        return project;
    }

    public Employee getEmployee() {
        return employee;
    }
    
    
    
}

