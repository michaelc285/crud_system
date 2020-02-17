package com.empsystem.entity;

import java.util.Date;

/**
 * 
 * @author Michael
 */
public class Project {

    private Integer project_id;
    private Integer project_leader;
    private String project_name;
    private Date start_date;
    private Date end_date;
    private Integer duration;
    private String description;
    private Integer task_id;
    private Integer emp_no;
    private String task_description;



    public Project(Integer project_id, Integer task_id ,String project_name ,Integer project_leader, Integer emp_no, Date start_date, Integer duration, Date end_date,  String task_description) {
        this.project_id = project_id;
        this.task_id = task_id;
        this.project_leader = project_leader;
        this.project_name = project_name;
        this.start_date = start_date;
        this.duration = duration;
        this.end_date = end_date;
        this.task_description = task_description;
        this.emp_no = emp_no;
    }

    public Project(Integer project_id, Integer project_leader, String project_name, Date start_date, Date end_date, String description , Integer duration) {
        this.project_id = project_id;
        this.project_leader = project_leader;
        this.project_name = project_name;
        this.start_date = start_date;
        this.duration = duration;
        this.end_date = end_date;
        this.description = description;
    }

    public Project(Integer project_leader, Integer project_id, String project_name, Integer task_id , String task_description) {
        this.project_leader = project_leader;
        this.project_id = project_id;
        this.project_name = project_name;
        this.task_id = task_id;
        this.task_description=task_description;
    }
            
    

    public Integer getProject_id() {
        return this.project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }
    
    public Integer getTask_id() {
        return this.task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public Integer getProject_leader() {
        return project_leader;
    }

    public void setProject_leader(Integer project_leader) {
        this.project_leader = project_leader;
    }

    public String getProject_name() {
        return this.project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Integer getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(Integer emp_no) {
        this.emp_no = emp_no;
    }

    public Date getStart_date() {
        return this.start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }


    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
        public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    
    
    

}




