package com.empsystem.dao;


import com.empsystem.entity.TableManager;
import com.empsystem.entity.Project;
import com.empsystem.entity.SearchSelection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.util.Date;


/**
 * ProjectDaoImpl
 * @author Michael
 */
public class ProjectDaoImpl implements ProjectDao {
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private PreparedStatement pstmt;
    private String query;

    
    //get all task list
    @Override
    public ArrayList<Project> taskList() {
        Database db = new Database();
        ArrayList<Project> taskList = new ArrayList<>();
        if(db.connect()){            
            conn = db.getConnection();
            query = "select project_partake.project_id, task_id , project_name, project_leader,emp_no, start_date, duration, end_date,  project_partake.description " +
                        "from employees.project_partake left join employees.project "+
                        "on project_partake.project_id = project.project_id;";
            try{
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);               
                Project task;
                while(rs.next()){
                    //(Integer project_id, Integer task_id ,String project_name ,Integer project_leader, Integer emp_no, Date start_date, Integer duration, Date end_date,  String description)            
                    task = new Project(rs.getInt("project_id"),rs.getInt("task_id"),rs.getString("project_name"),
                                        rs.getInt("project_leader"),rs.getInt("emp_no"),rs.getDate("start_date"),
                                        rs.getInt("duration"),rs.getDate("end_date"),
                                        rs.getString("description"));                 
                    taskList.add(task);                    
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
        return taskList;
    }
        
    @Override
    public ArrayList<Project> taskListForProjectLeader(Integer project_leader, SearchSelection selection, String searchValue) {
        Database db = new Database();
        ArrayList<Project> taskList = new ArrayList<>();
        String extraQuery;
        switch(selection){
            case PROJECT_ID:
                extraQuery=" AND project_partake.project_id LIKE ? ";
                break;
            case PROJECT_NAME:
                extraQuery=" AND project_name LIKE ?";
                break;
            case PROJECT_LEADER_ID:
                extraQuery=" AND project_leader LIKE ?";
                break;
            case PROJECT_STILL_PROCESSING:
                extraQuery=" AND end_date IS NULL";
                break;
            case PROJECT_ENDED:
                extraQuery=" AND end_date IS NOT NULL";
                break;
            case EMPLOYEE_NUMBER:
                extraQuery=" AND project_partake.emp_no LIKE ? ";
                break;
            default: 
                extraQuery="";
                break;
        }
        if(db.connect()){            
            conn = db.getConnection();
            query = "SELECT project_partake.project_id, task_id , project_name, project_leader,emp_no, start_date, duration, end_date,  project_partake.description \n" +
                    "FROM employees.project_partake \n" +
                    "LEFT JOIN employees.project ON project_partake.project_id = project.project_id \n" +
                    "WHERE project_leader= ? ";
            try{
                pstmt = conn.prepareStatement(query.concat(extraQuery));
                pstmt.setInt(1, project_leader);
                if(searchValue!=null) pstmt.setString(2, "%"+searchValue+"%");
                rs = pstmt.executeQuery();
                Project task;
                while(rs.next()){           
                    task = new Project(rs.getInt("project_id"),rs.getInt("task_id"),rs.getString("project_name"),
                                        rs.getInt("project_leader"),rs.getInt("emp_no"),rs.getDate("start_date"),
                                        rs.getInt("duration"),rs.getDate("end_date"),
                                        rs.getString("description"));                
                    taskList.add(task);                    
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
                    if(stmt!=null) stmt.close();
                }catch(SQLException se2){}
                
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }   
            } 
        }    
        return taskList;
    }

    @Override
    public ArrayList<Project> taskListForProjectMember(Integer emp_no, SearchSelection selection, String searchValue) {
        Database db = new Database();
        ArrayList<Project> taskList = new ArrayList<>();
        String extraQuery;
        switch(selection){
            case PROJECT_ID:
                extraQuery=" AND project_partake.project_id LIKE ? ";
                break;
            case PROJECT_NAME:
                extraQuery=" AND project_name LIKE ?";
                break;
            case PROJECT_LEADER_ID:
                extraQuery=" AND project_leader LIKE ?";
                break;
            case PROJECT_STILL_PROCESSING:
                extraQuery=" AND end_date IS NULL";
                break;
            case PROJECT_ENDED:
                extraQuery=" AND end_date IS NOT NULL";
                break;
            default: 
                extraQuery="";
                break;
        }
        
        if(db.connect()){            
            conn = db.getConnection();
            query = "SELECT project_partake.project_id, task_id , project_name, project_leader,emp_no, start_date, duration, end_date,  project_partake.description\n" +
                    "FROM project_partake\n" +
                    "LEFT JOIN employees.project ON project_partake.project_id = project.project_id\n" +
                    "WHERE emp_no = ?\n";
            try{
                pstmt=conn.prepareStatement(query.concat(extraQuery));
                pstmt.setInt(1, emp_no);
                if(searchValue!=null)pstmt.setString(2, "%"+searchValue+"%");
                rs = pstmt.executeQuery();
                
                Project task;
                while(rs.next()){       
                    task = new Project(rs.getInt("project_id"),rs.getInt("task_id"),rs.getString("project_name"),
                                        rs.getInt("project_leader"),rs.getInt("emp_no"),rs.getDate("start_date"),
                                        rs.getInt("duration"),rs.getDate("end_date"),
                                        rs.getString("project_partake.description"));                 
                    taskList.add(task);                    
                } 
            conn.close();
            rs.close();
            rs.close();               
            } catch (SQLException e) {
            e.printStackTrace();            
            }catch(Exception e){
            e.printStackTrace();
            }finally{
                try{
                    if(rs!=null) rs.close();
                }catch(SQLException se2){}                
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }   
            } 
        }    
        return taskList;
    }
    
    // Get all projects from db
    @Override
    public ArrayList<Project> projectList() {
        Database db = new Database();
        ArrayList<Project> projectList = new ArrayList<>();
        if(db.connect()){           
            conn = db.getConnection();
            query = "SELECT * FROM project;";            
            try{
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);
                
                Project project;
                while(rs.next()){
                    //(Integer project_id, Integer project_leader, String project_name, Date start_date, Date end_date, String description , Integer duration) 
                    project = new Project(rs.getInt("project_id"),rs.getInt("project_leader"),rs.getString("project_name"),
                                       rs.getDate("start_date"),rs.getDate("end_date"),
                                       rs.getString("description"),rs.getInt("duration"));      
                    projectList.add(project);                    
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
        return projectList;
    }
        
    //Get project List by project leader id with differnt search condition
    @Override
    public ArrayList<Project> projectListByProjectLeader(Integer project_leader, SearchSelection selection, String searchValue) {
        Database db = new Database();
        ArrayList<Project> projectList = new ArrayList<>();
        String extraQuery;
        switch(selection){
            case PROJECT_ID:
                extraQuery=" AND project_id LIKE ?;";
                break;
            case PROJECT_NAME:
                extraQuery=" AND project_name LIKE ?;";
                break;
            case PROJECT_STILL_PROCESSING:
                extraQuery=" AND duration IS NULL;";
                break;
            case PROJECT_ENDED:
                extraQuery=" AND duration IS NOT NULL;";
                break;
            default:
                extraQuery="";
                break;
        }
    
        if(db.connect()){        
            conn = db.getConnection();
            query = "SELECT * FROM project WHERE project_leader=?";         
            try{
                pstmt = conn.prepareStatement(query.concat(extraQuery));
                pstmt.setInt(1, project_leader);
                if(searchValue!=null) pstmt.setString(2, "%"+searchValue+"%");            
                rs = pstmt.executeQuery();
                Project project;
                while(rs.next()){
                    project = new Project(rs.getInt("project_id"),rs.getInt("project_leader"),rs.getString("project_name"),
                                       rs.getDate("start_date"),rs.getDate("end_date"),
                                       rs.getString("description"),rs.getInt("duration"));              
                    projectList.add(project);       
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
                    if(stmt!=null) stmt.close();
                }catch(SQLException se2){}
                
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }   
            } 
        }    
        return projectList;
    }
        
    
    // get project list by project_leader_id
    @Override
    public ArrayList<TableManager> projectMemberList(Integer projectLeaderID) {
        
        Database db = new Database();
        ArrayList<TableManager> projectMemberList = new ArrayList<>();
        
        if(db.connect()){
            
            conn = db.getConnection();
            query = "SELECT project_leader ,project.project_id, project.project_name, task_id, project_partake.emp_no, first_name, last_name, title, gender, project_partake.description " +
                     "FROM project " +
                     "LEFT JOIN project_partake ON project.project_id = project_partake.project_id " +
                     "LEFT JOIN employees ON employees.emp_no = project_partake.emp_no " +
                     "LEFT JOIN titles ON project_partake.emp_no = titles.emp_no " +
                     "WHERE task_id IS NOT NULL " +
                     "AND titles.to_date >current_timestamp " +
                     "AND project.duration IS NULL "+
                     "AND project_leader = "+ projectLeaderID+";";
            try{                
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);
                TableManager task;
                //Integer project_leader,Integer project_id, String project_name, Integer task_id , String description, Integer employee_no, String first_name, String last_name, String gender, String title
                while(rs.next()){
                    task = new TableManager(rs.getInt("project_leader"),rs.getInt("project_id"),rs.getString("project_name"),
                                                rs.getInt("task_id"),rs.getString("description"),rs.getInt("emp_no"),
                                                rs.getString("first_name"),rs.getString("last_name"),rs.getString("gender"),
                                                rs.getString("title"));                 
                    projectMemberList.add(task);
                    
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
        return projectMemberList;        
    }
    //Manager Edit Task Panel -> project member table
    @Override
    public ArrayList<TableManager> projectMemberList(Integer projectLeaderID, Integer projectID){
        Database db = new Database();
        ArrayList<TableManager> projectMemberList=new ArrayList<>();
        if(db.connect()){
            conn = db.getConnection();            
            try{
                query = "SELECT project_leader ,project.project_id, project.project_name, task_id, project_partake.emp_no, first_name, last_name, title, gender, project_partake.description " +
                     "FROM project " +
                     "LEFT JOIN project_partake ON project.project_id = project_partake.project_id " +
                     "LEFT JOIN employees ON employees.emp_no = project_partake.emp_no " +
                     "LEFT JOIN titles ON project_partake.emp_no = titles.emp_no " +
                     "WHERE task_id IS NOT NULL " +
                     "AND titles.to_date >current_timestamp " +
                     "AND project_leader = ? AND project.project_id = ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, projectLeaderID);
                pstmt.setInt(2,projectID); 
                
                rs = pstmt.executeQuery();
                TableManager task;
                //Integer project_leader,Integer project_id, String project_name, Integer task_id , String description, Integer employee_no, String first_name, String last_name, String gender, String title
                while(rs.next()){
                    task = new TableManager(rs.getInt("project_leader"),rs.getInt("project_id"),rs.getString("project_name"),
                                                rs.getInt("task_id"),rs.getString("description"),rs.getInt("emp_no"),
                                                rs.getString("first_name"),rs.getString("last_name"),rs.getString("gender"),
                                                rs.getString("title"));                 
                    projectMemberList.add(task);                    
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
        return projectMemberList;
    } 
    
    //Create a project with end_date and Actual Start date
    @Override
    public void createProject(Integer project_leader, String project_name, Date start_date, Date end_date, String description) {       
        Database db = new Database();      
        Integer duration = (int)( (end_date.getTime() - start_date.getTime()) / (1000 * 60 * 60 * 24) );
        java.sql.Date sqlType_start_date = new java.sql.Date(start_date.getTime());
        java.sql.Date sqlType_end_date = new java.sql.Date(end_date.getTime()); //Chnage to end_date
 
        if(db.connect()){
           conn = db.getConnection();          
            try{
                query = "insert into project(project_id, project_leader, project_name, start_date, end_date, duration, description )"
                                                + "values(?,?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(query);
                
                pstmt.setInt(1, newProjectId());
                pstmt.setInt(2, project_leader);
                pstmt.setString(3, project_name);
                pstmt.setDate(4, sqlType_start_date);
                pstmt.setDate(5, sqlType_end_date);
                pstmt.setInt(6, duration);
                pstmt.setString(7, description);
                
                int i = pstmt.executeUpdate();
                
                if(i>0){
                    System.out.println("Project Created");
                }     
                conn.close();
                pstmt.close();     
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
        
    }
    
    //Create a project without end date
    @Override 
    public void createProject(Integer project_leader, String project_name, Date start_date, String description) {
        Database db = new Database();       
        if(db.connect()){           
            conn = db.getConnection();          
            try{
                query = "insert into project(project_id, project_leader, project_name, start_date, description ) values(?,?,?,?,?)";
                pstmt = conn.prepareStatement(query);                
                pstmt.setInt(1, newProjectId());
                pstmt.setInt(2, project_leader);
                pstmt.setString(3, project_name);
                pstmt.setDate(4, new java.sql.Date(start_date.getTime()));           
                pstmt.setString(5, description);
                
                int i = pstmt.executeUpdate();                
                if(i>0){
                    System.out.println("Project Created");
                }            
                conn.close();
                pstmt.close();                            
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
    }
        
    
    // Delete project by project_id
    @Override 
    public void deleteProject(Integer project_id) {       
        deleteTaskByProject(project_id); // Delete the foreign key in project_partake first        
        Database db = new Database();           
        if(db.connect()){            
           conn = db.getConnection();
           try{
                query= "DELETE FROM project WHERE project_id = ?";
                pstmt = conn.prepareStatement(query);                
                pstmt.setInt(1, project_id);
                
                int i = pstmt.executeUpdate();
                
                if(i>0){
                    System.out.println("Project Delete succeed");
                }
                conn.close();
                pstmt.close();
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
    }
       
    @Override
    public void updateProject(Integer project_id, Integer project_leader, String project_name, Date start_date, Date end_date, String description) {
        Integer duration=null;
        java.sql.Date Sql_endDate=null;
        
        if(end_date!=null){
            duration = (int)( (end_date.getTime() - start_date.getTime()) / (1000 * 60 * 60 * 24) );
            Sql_endDate = new java.sql.Date(end_date.getTime());
        }
        
        Database db = new Database();        
        if(db.connect()){
            
            conn = db.getConnection();
            query = "UPDATE project set project_leader=?, project_name=?, start_date=?,  end_date=?, duration=?, description=? WHERE project_id=?";
            
            try{                 
                pstmt = conn.prepareStatement(query);
                
                pstmt.setInt(1, project_leader); //project leader
                pstmt.setString(2, project_name); // project name
                pstmt.setDate(3, new java.sql.Date(start_date.getTime())); // start date sql type           
                pstmt.setDate(4, Sql_endDate); // end date sql type
                pstmt.setInt(5, duration); // duration
                pstmt.setString(6, description);// description
                pstmt.setInt(7, project_id);// project id
                
                int i = pstmt.executeUpdate();
                
                if(i>0){
                    System.out.println("Update succeed");
                }              
            conn.close();
            pstmt.close();               
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
    }    
    
    //Update project by project_id remove end_date
    //project_leader, project_name, start_date, duration, actual_start_date, description [ Without end date therefore do not have actual_duration]
    @Override
    public void updateProject(Integer project_id, Integer project_leader, String project_name, Date start_date, String description) {
        Database db = new Database();
        
        if(db.connect()){
            
            conn = db.getConnection();
            query = "UPDATE project set project_leader=?, project_name=?, start_date=?, end_date=null, duration=null, description=? WHERE project_id=?";
            
            try{
                pstmt = conn.prepareStatement(query);
                
                pstmt.setInt(1, project_leader); //project leader
                pstmt.setString(2, project_name); // project name
                pstmt.setDate(3, new java.sql.Date(start_date.getTime())); // start date                            
                pstmt.setString(4, description);// description
                pstmt.setInt(5, project_id);// project id
                
                int i = pstmt.executeUpdate();
                
                if(i>0){
                    System.out.println("Update succeed");
                }             
            conn.close();
            pstmt.close();               
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
    }    

    //create task
    //task_id, project_id, emp_no, taskDescription
    @Override
    public void createTask(Integer project_id, Integer emp_no, String taskDescription) {
        Database db = new Database();
               
        if(db.connect()){
           conn = db.getConnection();          
            try{
                query = "INSERT INTO project_partake(task_id, project_id, emp_no, description) VALUES(?, ?, ?, ?);";
                pstmt = conn.prepareStatement(query);
                
                pstmt.setInt(1, newTaskID());
                pstmt.setInt(2, project_id);
                pstmt.setInt(3, emp_no);
                pstmt.setString(4, taskDescription);
                
                int i = pstmt.executeUpdate();
                
                if(i>0){
                    System.out.println("succeed");
                }
            
                conn.close();
                pstmt.close();            
                
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
    }

    
    //Update task by task_id
    //project_id, emp_no, taskDescription
    @Override
    public void updateTask(Integer task_id, Integer project_id, Integer emp_no, String taskDescription) {
           
        Database db = new Database();
        
        if(db.connect()){
            
            conn = db.getConnection();
            query = "UPDATE project_partake SET project_id = ? , emp_no = ? , description = ?  WHERE task_id = ? ;";
            
            try{
                pstmt = conn.prepareStatement(query);
                
                pstmt.setInt(1, project_id); //project id
                pstmt.setInt(2, emp_no); // employee id
                pstmt.setString(3, taskDescription); // task description
                pstmt.setInt(4, task_id); // target task id
                
                
                int i = pstmt.executeUpdate();
                
                if(i>0){
                    System.out.println("Update succeed");
                }
                
                
            conn.close();
            pstmt.close();
            
                
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
    }
    
    //delete Task by task_id
    @Override
    public void deleteTask(Integer task_id) {
       
        
        Database db = new Database();
           
        if(db.connect()){
            
            conn = db.getConnection();
           try{
                query= "DELETE FROM project_partake WHERE task_id = ?";
                pstmt = conn.prepareStatement(query);                
                pstmt.setInt(1, task_id);
                
                int i = pstmt.executeUpdate();
                
                if(i>0){
                    System.out.println("Project Delete succeed");
                }
           
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
    }
    
    
    // Delete task by project_id
    @Override
    public void deleteTaskByProject(Integer project_id) {
        Database db = new Database();
           
        if(db.connect()){
            
            conn = db.getConnection();
           try{
                query= "DELETE FROM project_partake WHERE project_id = ?";
                pstmt = conn.prepareStatement(query);                
                pstmt.setInt(1, project_id);
                
                int i = pstmt.executeUpdate();
                
                if(i>0){
                    System.out.println("Task Delete succeed");
                }

                conn.close();
                pstmt.close();
                            
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
    }


        //Create the project id by using the largest project_id + 1
    @Override
    public Integer newProjectId() {

            Integer newProject_id = 0;

            for(Project p : projectList()){
                if(p.getProject_id()>newProject_id){
                    newProject_id = p.getProject_id() ;
                }
            }
            newProject_id+=1;
            return newProject_id;
        }

        
            //Create the task id by using the largest task_id + 1
    @Override
    public Integer newTaskID() {
            Integer newTask_id = 0;

            for(Project task : taskList()){
                if(task.getTask_id()>newTask_id){
                    newTask_id = task.getTask_id() ;
                }
            }
            newTask_id+=1;
            return newTask_id;
        }


    
    }



    




    
























































































































