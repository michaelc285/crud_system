/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.ui.panel.manager;

import com.empsystem.entity.PanelStore;
import com.empsystem.entity.SearchSelection;
import com.empsystem.ui.BasePanel;
import static com.empsystem.ui.PanelConstant.*;
import com.empsystem.ui.frame.SubFrame;




/**
 *
 * @author Michael
 */
public class ManagerMainPanelUI extends BasePanel {
    private Integer selectTabbedPaneIndex=0;
    
    /**
     * Creates new form ManagerMainPanelUI
     * @param ps
     */
    public ManagerMainPanelUI(PanelStore ps) {
        super(ps);
    }
    
    @Override
    public void setupPage() {
        refreshDeptTable();
        refreshTaskTable();
        refreshProjectTable();
        jTabbedPane.setSelectedIndex(0);
    }
    
    @Override
    public void init() {
        initComponents();           
    }
    
    
    public void refreshTaskTable(){
        cleanTableModel(taskTable);
        getStaffTaskTableModel(projectDao.taskListForProjectLeader(loginEmployee.getEmployee_no(), SearchSelection.ALL, null) ,taskTable);
        System.out.println("Task Table refreshed");
    }
    
    public void refreshDeptTable(){
        cleanTableModel(deptartmentMemberTable);
        getDepartmentMemberTableModel(departmentDao.departmentMembersList(loginEmployee.getDepartment_no(),SearchSelection.ALL, null), deptartmentMemberTable);
        System.out.println("Department Table refreshed");
    }
    
    public void refreshProjectTable(){
        cleanTableModel(projectTable);
        getProjectTableModel(projectDao.projectListByProjectLeader(loginEmployee.getEmployee_no(), SearchSelection.ALL, null) ,projectTable);
        System.out.println("Project Table refreshed");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editProjectButton1 = new javax.swing.JButton();
        logoutBotton = new javax.swing.JButton();
        personalInfoBotton1 = new javax.swing.JButton();
        editProjectButton = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        deptartmentMemberTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        projectTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        taskTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        refreshButton = new javax.swing.JButton();
        searchComboBox = new javax.swing.JComboBox<>();
        searchDepartmentTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        editProjectButton1.setText("Edit Project");
        editProjectButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProjectButton1ActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1627, 847));
        setPreferredSize(new java.awt.Dimension(1622, 819));

        logoutBotton.setText("Logout");
        logoutBotton.setActionCommand("logoutBotton");
        logoutBotton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBottonMouseClicked(evt);
            }
        });
        logoutBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBottonActionPerformed(evt);
            }
        });

        personalInfoBotton1.setText("Personal INFO");
        personalInfoBotton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personalInfoBotton1MouseClicked(evt);
            }
        });
        personalInfoBotton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalInfoBotton1ActionPerformed(evt);
            }
        });

        editProjectButton.setText("Edit Project");
        editProjectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editProjectButtonMouseClicked(evt);
            }
        });
        editProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProjectButtonActionPerformed(evt);
            }
        });

        jTabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneMouseClicked(evt);
            }
        });

        deptartmentMemberTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee No.", "Title", "First Name", "Last Name", "From Date", "To Date", "Gender", "Hire Date", "Current Partake Count", "Total Partake Count"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        deptartmentMemberTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deptartmentMemberTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(deptartmentMemberTable);

        jTabbedPane.addTab("Department Members", jScrollPane5);

        projectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Project ID", "Project Leader", "Project Name", "Start Date", "End Date", "Duration", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        projectTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projectTableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(projectTable);

        jTabbedPane.addTab("Projects", jScrollPane7);

        taskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Project ID", "Task ID", "Project Name", "Project Leader", "Emp No", "Start Date", "End Date", "Duration", "Task Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(taskTable);

        jTabbedPane.addTab("Tasks", jScrollPane3);

        refreshButton.setText("Refresh");
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
        });
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        searchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "Job Title", "Employee Name", "Employee ID", "Current Job Count ( <= )", "Current Job Count ( >= )", "Total Job Count ( <= )", "Total Job Count ( >= )" }));
        searchComboBox.setPreferredSize(new java.awt.Dimension(148, 23));
        searchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComboBoxActionPerformed(evt);
            }
        });

        searchDepartmentTextField.setPreferredSize(new java.awt.Dimension(7, 23));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1610, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(searchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(searchDepartmentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(searchButton)
                .addGap(335, 335, 335)
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(editProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(personalInfoBotton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(logoutBotton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchDepartmentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personalInfoBotton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutBotton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        editProjectButton.getAccessibleContext().setAccessibleName("editProjectButton");
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBottonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBottonMouseClicked

    }//GEN-LAST:event_logoutBottonMouseClicked

    private void personalInfoBotton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalInfoBotton1ActionPerformed
       new SubFrame().showSubPanelUI();      
    }//GEN-LAST:event_personalInfoBotton1ActionPerformed

    private void editProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProjectButtonActionPerformed
        ps.showJPanel(MANAGER_EDIT_PROJECT);       
    }//GEN-LAST:event_editProjectButtonActionPerformed

    private void editProjectButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProjectButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editProjectButton1ActionPerformed

    private void editProjectButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProjectButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_editProjectButtonMouseClicked

    private void personalInfoBotton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personalInfoBotton1MouseClicked
        
    }//GEN-LAST:event_personalInfoBotton1MouseClicked

    private void deptartmentMemberTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deptartmentMemberTableMouseClicked

    }//GEN-LAST:event_deptartmentMemberTableMouseClicked

    private void logoutBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBottonActionPerformed
        logout();
    }//GEN-LAST:event_logoutBottonActionPerformed

    private void projectTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projectTableMouseClicked
        
    }//GEN-LAST:event_projectTableMouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshButtonMouseClicked

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refreshDeptTable();
        refreshTaskTable();
        refreshProjectTable();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void searchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchComboBoxActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        switch(selectTabbedPaneIndex){
            case 0:
                departmentMembersSearch();
                break;
            case 1:
                searchProjects();
                break;
            case 2:
                searchTask();
                break;        
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void jTabbedPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneMouseClicked
        selectTabbedPaneIndex=jTabbedPane.getSelectedIndex();
        updateSearchComboBox(selectTabbedPaneIndex);
    }//GEN-LAST:event_jTabbedPaneMouseClicked
    
    private void departmentMembersSearch(){
         String inputValue=searchDepartmentTextField.getText();
         System.out.println("Searching: " + inputValue);
         cleanTableModel(deptartmentMemberTable);     
         switch(searchComboBox.getSelectedIndex()){
             case 0: //All
                 getDepartmentMemberTableModel(departmentDao.departmentMembersList(loginEmployee.getDepartment_no(),SearchSelection.ALL, null), deptartmentMemberTable);
                 break;
             case 1: // Job Title
                 getDepartmentMemberTableModel(departmentDao.departmentMembersList(loginEmployee.getDepartment_no(),SearchSelection.JOB_TITLE, inputValue), deptartmentMemberTable);
                 break;
             case 2: // Emp Name
                 getDepartmentMemberTableModel(departmentDao.departmentMembersList(loginEmployee.getDepartment_no(),SearchSelection.EMPLOYEE_FULL_NAME, inputValue), deptartmentMemberTable);
                 break;
             case 3:// Emp ID
                 getDepartmentMemberTableModel(departmentDao.departmentMembersList(loginEmployee.getDepartment_no(),SearchSelection.EMPLOYEE_NUMBER, inputValue), deptartmentMemberTable);
                 break;
             case 4:// Current Job Less and equal
                 getDepartmentMemberTableModel(departmentDao.departmentMembersList(loginEmployee.getDepartment_no(),SearchSelection.CURRENT_PARTAKE_JOB_LESS_AND_EQUAL, inputValue), deptartmentMemberTable);
                 break;
             case 5: // Current Job Greater and equal
                 getDepartmentMemberTableModel(departmentDao.departmentMembersList(loginEmployee.getDepartment_no(),SearchSelection.CURRENT_PARTAKE_JOB_GREATER_AND_EQUAL, inputValue), deptartmentMemberTable);
                 break;             
             case 6: //Total Job less and equal
                 getDepartmentMemberTableModel(departmentDao.departmentMembersList(loginEmployee.getDepartment_no(),SearchSelection.TOTAL_PARTAKE_JOB_LESS_AND_EQUAL, inputValue), deptartmentMemberTable);
                 break;
             case 7://Total Job Greater and equal
                 getDepartmentMemberTableModel(departmentDao.departmentMembersList(loginEmployee.getDepartment_no(),SearchSelection.TOTAL_PARTAKE_JOB_GREATER_AND_EQUAL, inputValue), deptartmentMemberTable);
                 break;
             default:
                 System.out.println("What are you searching");           
                 break;
         }
    }
    
    
     private void searchProjects(){
         String searchValue = searchDepartmentTextField.getText();
         System.out.println("Searching: "+ searchValue);
         cleanTableModel(projectTable);
         switch(searchComboBox.getSelectedIndex()){            
            case 0: //All
                getProjectTableModel(projectDao.projectListByProjectLeader(loginEmployee.getEmployee_no(), SearchSelection.ALL, null) ,projectTable);      
                break;
            case 1://search by project id                  
                getProjectTableModel(projectDao.projectListByProjectLeader(loginEmployee.getEmployee_no(), SearchSelection.PROJECT_ID, searchValue) ,projectTable);       
                break;
            case 2://search by project name
                getProjectTableModel(projectDao.projectListByProjectLeader(loginEmployee.getEmployee_no(), SearchSelection.PROJECT_NAME, searchValue) ,projectTable);
                break;
            case 3: // Still processing project
                getProjectTableModel(projectDao.projectListByProjectLeader(loginEmployee.getEmployee_no(), SearchSelection.PROJECT_STILL_PROCESSING, null) ,projectTable);
                break;
            case 4: // Ended project
                getProjectTableModel(projectDao.projectListByProjectLeader(loginEmployee.getEmployee_no(), SearchSelection.PROJECT_ENDED, null) ,projectTable);
                break;
            default: break;              
        }       
    }
    
     private void searchTask(){
        String inputValue = searchDepartmentTextField.getText();
        System.out.println("Search Task : "+inputValue);
        cleanTableModel(taskTable);
        switch(searchComboBox.getSelectedIndex()){
            case 0: // ALL task
                getStaffTaskTableModel(projectDao.taskListForProjectLeader(loginEmployee.getEmployee_no(), SearchSelection.ALL, null) ,taskTable);
                break;
            case 1:// project id
                getStaffTaskTableModel(projectDao.taskListForProjectLeader(loginEmployee.getEmployee_no(), SearchSelection.PROJECT_ID, inputValue) ,taskTable);
                break;
            case 2: // Project name
                getStaffTaskTableModel(projectDao.taskListForProjectLeader(loginEmployee.getEmployee_no(), SearchSelection.PROJECT_NAME, inputValue) ,taskTable);
                break;
            case 3:// project still processing
                getStaffTaskTableModel(projectDao.taskListForProjectLeader(loginEmployee.getEmployee_no(), SearchSelection.PROJECT_STILL_PROCESSING, null) ,taskTable);
                break;
            case 4:// project end
                getStaffTaskTableModel(projectDao.taskListForProjectLeader(loginEmployee.getEmployee_no(), SearchSelection.PROJECT_ENDED, null) ,taskTable);
                break;
            case 5:// Employee ID
                getStaffTaskTableModel(projectDao.taskListForProjectLeader(loginEmployee.getEmployee_no(), SearchSelection.EMPLOYEE_NUMBER, inputValue) ,taskTable);
            default: 
                System.out.println("What are you looking for");
                break;
        }
    }
     
     private void updateSearchComboBox(Integer index){
        cleanComboBox(searchComboBox);        
        System.out.println("TabbedPane index: " + index);        
        switch(index){
            case 0: // DepartmentMember Table
                searchComboBox.addItem("Job Title");
                searchComboBox.addItem("Employee Name");
                searchComboBox.addItem("Employee ID");
                searchComboBox.addItem("Current Job Count ( <= )");
                searchComboBox.addItem("Current Job Count ( >= )");
                searchComboBox.addItem("Total Job Count ( <= )");
                searchComboBox.addItem("Total Job Count ( >= )");
                break;
            case 1: // Project Table
                searchComboBox.addItem("Project ID");
                searchComboBox.addItem("Project Name");
                searchComboBox.addItem("Project Still Processing");
                searchComboBox.addItem("Project Ended");
                break;
            case 2: // Task Table
                searchComboBox.addItem("Project ID");
                searchComboBox.addItem("Project Name");
                searchComboBox.addItem("Project/Task Still Processing");
                searchComboBox.addItem("Project/Task Ended");
                searchComboBox.addItem("Employee ID");
                break;
            default: break;        
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable deptartmentMemberTable;
    private javax.swing.JButton editProjectButton;
    private javax.swing.JButton editProjectButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JButton logoutBotton;
    private javax.swing.JButton personalInfoBotton1;
    private javax.swing.JTable projectTable;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> searchComboBox;
    private javax.swing.JTextField searchDepartmentTextField;
    private javax.swing.JTable taskTable;
    // End of variables declaration//GEN-END:variables

    

}
