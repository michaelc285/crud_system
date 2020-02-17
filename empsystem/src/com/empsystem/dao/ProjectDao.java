package com.empsystem.dao;


import com.empsystem.entity.TableManager;
import com.empsystem.entity.Project;
import com.empsystem.entity.SearchSelection;
import java.util.ArrayList;
import java.util.Date;


/**
 * ProjectDao
 * @author Michael
 */
public interface ProjectDao {
    ArrayList<Project> taskList();
    ArrayList<Project> taskListForProjectLeader(Integer project_leader, SearchSelection selection, String searchValue);
    ArrayList<Project> taskListForProjectMember(Integer emp_no, SearchSelection selection, String searchValue);
    
    ArrayList<Project> projectList();
    ArrayList<Project> projectListByProjectLeader(Integer project_leader, SearchSelection selection, String searchValue);
    
    ArrayList<TableManager> projectMemberList(Integer projectLeaderID);
    ArrayList<TableManager> projectMemberList(Integer projectLeaderID, Integer projectID);
    
    void createProject(Integer project_leader, String project_name, Date start_date, Date end_date, String description);
    void createProject(Integer project_leader, String project_name, Date start_date, String description);
    
            
    void deleteProject(Integer project_id);
       
    void updateProject(Integer project_id, Integer project_leader, String project_name, Date start_date, Date end_date, String description);
    void updateProject(Integer project_id, Integer project_leader, String project_name, Date start_date, String description);
    
     
    void createTask(Integer project_id, Integer emp_no ,String taskDescription);
    
    void updateTask(Integer task_id, Integer project_id, Integer emp_no, String taskDescription);
    
    void deleteTask(Integer task_id);
    void deleteTaskByProject(Integer project_id);
    

    
    Integer newProjectId();
    Integer newTaskID();

}
















