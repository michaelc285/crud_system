/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.ui.panel.admin;

import com.empsystem.entity.AccountStatus;
import com.empsystem.entity.Department;
import com.empsystem.entity.PanelStore;
import com.empsystem.ui.BasePanel;
import com.empsystem.ui.frame.SubFrame;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.empsystem.entity.SearchSelection;

/**
 *
 * 
 * 
 * @author Michael
 */


public class AdminMainPanelUI extends BasePanel {
    private Date today = new Date();
    private int maxAge = 65;
    private int minAge = 16;
    private Date maxDate = dateControl(minAge);
    private Date minDate = dateControl(maxAge);
    private String gender = "M";
    private Integer selectedPendingApprovalIndex=null;
    private Integer selectedCurrentEmployeeIndex=null;
    
    /**
     * Creates new form AdminMainPanelUI
     * @param ps
     */
    public AdminMainPanelUI(PanelStore ps) {
        super(ps);
    }
    
    @Override
    public void init() {
        initComponents();
    }

    @Override
    public void setupPage() {
        registryFormClear();
        setDepartmentComboBox();
        birthDateChooser.setSelectableDateRange(minDate, maxDate);
        refreshPendingApproveTable();
        refreshCurrentEmployeesTable();
        currentEmployeeSearchTextField.setText("");
    }
    
    private void registryWarningLabelHide(){
        warningLabel.setVisible(false);
        warningLabel1.setVisible(false);
        warningLabel2.setVisible(false);
        warningLabel3.setVisible(false);
        warningLabel4.setVisible(false);
        warningLabel5.setVisible(false);
        warningLabel6.setVisible(false);
        warningLabel7.setVisible(false);
    }
    
    private void registryFormClear(){        
        registryWarningLabelHide();
        usernameTextField.setText("");
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        birthDateChooser.setDate(maxDate);
        maleRadioButton.setSelected(true);
        departmentComboBox.setSelectedIndex(0);
        cleanComboBox(titleComboBox);        
    }   
    
    private void refreshPendingApproveTable(){
        cleanTableModel(pendingApprovalTable);
        pendingApprovalTable.setModel(getAdminMainMenuTableModel(departmentDao.employeeInvalidAccount(SearchSelection.ALL, null)));
        selectedPendingApprovalIndex=null;
    }
    
    private void refreshCurrentEmployeesTable(){
        cleanTableModel(cancelEmployeeTable);
        cancelEmployeeTable.setModel(getAdminMainMenuTableModel(departmentDao.currentEmployeesList(SearchSelection.ALL, null)));
        selectedCurrentEmployeeIndex=null;
    }
    
     private String getRegistryFormDeptNo(){
        if(departmentComboBox.getSelectedIndex()<=0)return null;                        
        return departmentComboBox.getSelectedItem().toString().substring(0, 4).toLowerCase();       
     }
     
     private String getRegistryFormTitle(){
        if(titleComboBox.getSelectedIndex()<=0)return null;                        
        return titleComboBox.getSelectedItem().toString(); 
     }
     
     private void setDepartmentComboBox(){
         departmentDao.getDepartmentList().forEach((dept) -> {
             departmentComboBox.addItem(dept.getDepartment_no().toUpperCase()+"  -  "+dept.getDeparment_name());
        });
     }
     
     private void setJobTitleComboBoxContent(){
         cleanComboBox(titleComboBox);
         
         titleComboBox.addItem("Staff");
         titleComboBox.addItem("Senior Staff");
         titleComboBox.addItem("Manager");
         
         switch(getRegistryFormDeptNo()){
             case "d001":// Marketing
                 titleComboBox.addItem("Market Director");
                 break;
             case "d002"://Finance
                 titleComboBox.addItem("Finance Direcotr");
                 break;                 
             case "d004"://Development
                 titleComboBox.addItem("Enginner");
                 titleComboBox.addItem("Senior Enginner");
                 break;
             default : break; //d000, d003, d005                 
         }
     }
     
     private boolean nameCheckAndWarning(String inputName, String nameType,JLabel targetLabel){
        boolean error = false;
        //check last name pattern
        if(inputName.equals("")){
            targetLabel.setVisible(true);            
            targetLabel.setText("Please enter "+ nameType.toLowerCase() +" name");
            error=true;
        }else if(!employeeDao.namePattern(inputName)){
            targetLabel.setVisible(true);
            targetLabel.setText("Only accept englih letter and less than 32 char");
            error=true;
        }
        return error;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderButtonGroup = new javax.swing.ButtonGroup();
        logoutButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        birthDateChooser = new com.toedter.calendar.JDateChooser();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        maleRadioButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        genderLabel = new javax.swing.JLabel();
        birthDateLabel = new javax.swing.JLabel();
        jobTitleLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        titleComboBox = new javax.swing.JComboBox<>();
        departmentComboBox = new javax.swing.JComboBox<>();
        titleLabel1 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        warningLabel = new javax.swing.JLabel();
        warningLabel1 = new javax.swing.JLabel();
        warningLabel2 = new javax.swing.JLabel();
        warningLabel3 = new javax.swing.JLabel();
        warningLabel4 = new javax.swing.JLabel();
        warningLabel5 = new javax.swing.JLabel();
        warningLabel6 = new javax.swing.JLabel();
        warningLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pendingApprovalTable = new javax.swing.JTable();
        searchComboBox = new javax.swing.JComboBox<>();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        activateButton = new javax.swing.JButton();
        refreshRegistryPageButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        currentEmployeeSearchButton = new javax.swing.JButton();
        currentEmployeeSearchComboBox = new javax.swing.JComboBox<>();
        currentEmployeeSearchTextField = new javax.swing.JTextField();
        revokeCurrentEmployeeButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        cancelEmployeeTable = new javax.swing.JTable();
        refreshCurrentEmployeeButton = new javax.swing.JButton();
        personalInfoButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1184, 537));

        logoutButton.setText("Logout");
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registry Form", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        firstNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstNameLabel.setText("First Name");

        lastNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastNameLabel.setText("Last Name");

        genderButtonGroup.add(maleRadioButton);
        maleRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maleRadioButton.setText("Male");
        maleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioButtonActionPerformed(evt);
            }
        });

        genderButtonGroup.add(femaleRadioButton);
        femaleRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        femaleRadioButton.setText("Female");
        femaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioButtonActionPerformed(evt);
            }
        });

        genderLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        genderLabel.setText("Gender");

        birthDateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        birthDateLabel.setText("Birth Date");

        jobTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jobTitleLabel.setText("Job Title");

        submitButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitButtonMouseClicked(evt);
            }
        });
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        titleComboBox.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        titleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select Department First" }));
        titleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleComboBoxActionPerformed(evt);
            }
        });

        departmentComboBox.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select Department" }));
        departmentComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                departmentComboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });

        titleLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titleLabel1.setText("Department");

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameLabel.setText("Username");

        warningLabel.setForeground(new java.awt.Color(255, 102, 102));
        warningLabel.setText("That username is taken. Try another");

        warningLabel1.setForeground(new java.awt.Color(255, 102, 102));
        warningLabel1.setText("Please enter first name");

        warningLabel2.setForeground(new java.awt.Color(255, 102, 102));
        warningLabel2.setText("Please enter last name");

        warningLabel3.setForeground(new java.awt.Color(255, 102, 102));
        warningLabel3.setText("Please select birth date");

        warningLabel4.setForeground(new java.awt.Color(255, 102, 102));
        warningLabel4.setText("Please select gender");

        warningLabel5.setForeground(new java.awt.Color(255, 102, 102));
        warningLabel5.setText("Please select department");

        warningLabel6.setForeground(new java.awt.Color(255, 102, 102));
        warningLabel6.setText("Please select job title");

        warningLabel7.setForeground(new java.awt.Color(255, 102, 102));
        warningLabel7.setText("That username is taken. Try another");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jobTitleLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(firstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                .addComponent(birthDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(titleLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(maleRadioButton)
                                .addGap(33, 33, 33)
                                .addComponent(femaleRadioButton))
                            .addComponent(warningLabel1)
                            .addComponent(warningLabel2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(firstNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lastNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(warningLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(warningLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(warningLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(warningLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(departmentComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(birthDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(warningLabel7)
                            .addComponent(warningLabel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningLabel7)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(warningLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningLabel2)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maleRadioButton)
                    .addComponent(femaleRadioButton)
                    .addComponent(genderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningLabel4)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(birthDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(birthDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningLabel3)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLabel1))
                .addGap(7, 7, 7)
                .addComponent(warningLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobTitleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(clearButton))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pending Approval", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        pendingApprovalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee No.", "First Name", "Last Name", "Gender", "Department", "Job Title"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pendingApprovalTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pendingApprovalTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pendingApprovalTable);

        searchComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Employee No.", "Department Name", "Department Number", "Job Title", "Employee Name" }));
        searchComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchComboBoxMouseClicked(evt);
            }
        });
        searchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComboBoxActionPerformed(evt);
            }
        });

        searchTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        searchButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchButton.setText("Search");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });

        activateButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        activateButton.setText("Activate");
        activateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activateButtonMouseClicked(evt);
            }
        });

        refreshRegistryPageButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        refreshRegistryPageButton.setText("Refresh");
        refreshRegistryPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshRegistryPageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(searchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(activateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshRegistryPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(257, 257, 257))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(activateButton)
                    .addComponent(refreshRegistryPageButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 835, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Registry", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        currentEmployeeSearchButton.setText("Search");
        currentEmployeeSearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                currentEmployeeSearchButtonMouseClicked(evt);
            }
        });

        currentEmployeeSearchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Employee No.", "Department Name", "Department Number", "Job Title", "Employee Name" }));

        revokeCurrentEmployeeButton.setText("Revoke");
        revokeCurrentEmployeeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                revokeCurrentEmployeeButtonMouseClicked(evt);
            }
        });

        cancelEmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee No.", "First Name", "Last Name", "Gender", "Department", "Job Title"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cancelEmployeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelEmployeeTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(cancelEmployeeTable);

        refreshCurrentEmployeeButton.setText("Refresh");
        refreshCurrentEmployeeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshCurrentEmployeeButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(currentEmployeeSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentEmployeeSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentEmployeeSearchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(revokeCurrentEmployeeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshCurrentEmployeeButton)
                        .addContainerGap(282, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentEmployeeSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentEmployeeSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentEmployeeSearchButton)
                    .addComponent(revokeCurrentEmployeeButton)
                    .addComponent(refreshCurrentEmployeeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Revoke", jPanel3);

        personalInfoButton.setText("Personal Info");
        personalInfoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personalInfoButtonMouseClicked(evt);
            }
        });
        personalInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalInfoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(personalInfoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutButton)
                .addGap(34, 34, 34))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(personalInfoButton)
                    .addComponent(logoutButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        logout();
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        registryFormClear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void titleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleComboBoxActionPerformed

    private void departmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void searchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchComboBoxActionPerformed

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
        String username = usernameTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        Date birthDate = birthDateChooser.getDate();
        String deptNo = getRegistryFormDeptNo();
        String jobTitle = getRegistryFormTitle();
        String defaultPassword = "00000000";
        AccountStatus defaultStatus = AccountStatus.Invalid;
        boolean error = false;
        
        String warningText ="Are you sure to create employee ?";
        int dialogResult = JOptionPane.showConfirmDialog(null, warningText,"Warning",JOptionPane.YES_NO_OPTION);           
        if(dialogResult == JOptionPane.YES_OPTION){
            //Username pattern and existence check 
            if(!employeeDao.usernamePattern(username)){
                warningLabel.setVisible(true);
                warningLabel.setText("Username should be start with letter ");
                warningLabel7.setVisible(true);           
                warningLabel7.setText("and can only contain a-z,A-z,0-9");
                error=true;
            }else{
                if(!employeeDao.checkUsername(username)){
                    warningLabel7.setVisible(false);
                    warningLabel.setVisible(true);
                    warningLabel.setText("That username is taken. Try another");
                    error=true;
                }
            }

            //check first name pattern and null
            nameCheckAndWarning(firstName,"First" ,warningLabel1);

            //check last name pattern and null
            nameCheckAndWarning(lastName,"Last" ,warningLabel2);

            //check birth date no greather than current day
            if(birthDate==null){
                warningLabel3.setVisible(true);
                warningLabel3.setText("Please select birth date");
                error=true;
            }else if(birthDate.after(maxDate)||birthDate.before(minDate)){
                warningLabel3.setVisible(true);
                warningLabel3.setText("Only Accept "+minAge+" to "+maxAge+" Employee");
                error=true;
            }
            //check deptNo index !=  0
            if(deptNo==null){
                warningLabel5.setVisible(true);
                error=true;
            }
            //check jobTitle index !=  0    
            if(jobTitle==null){
                warningLabel6.setVisible(true);
                error=true;
            }

            // Create Employee
            if(!error){
                employeeDao.registry(username, firstName, lastName, gender, birthDate, deptNo, jobTitle, defaultPassword, defaultStatus );    
                refreshPendingApproveTable();
            }                
         }        
    }//GEN-LAST:event_submitButtonMouseClicked

    private void departmentComboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_departmentComboBoxPopupMenuWillBecomeInvisible
        if(getRegistryFormDeptNo()==null){
            cleanComboBox(titleComboBox);
        }else{
            setJobTitleComboBoxContent();
        }
    }//GEN-LAST:event_departmentComboBoxPopupMenuWillBecomeInvisible

    private void maleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioButtonActionPerformed
        gender="M";
    }//GEN-LAST:event_maleRadioButtonActionPerformed

    private void femaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioButtonActionPerformed
        gender="F";
    }//GEN-LAST:event_femaleRadioButtonActionPerformed

    private void personalInfoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personalInfoButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_personalInfoButtonMouseClicked

    private void personalInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalInfoButtonActionPerformed
        new SubFrame().showSubPanelUI();
    }//GEN-LAST:event_personalInfoButtonActionPerformed

    private void refreshRegistryPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshRegistryPageButtonActionPerformed
        refreshPendingApproveTable();
    }//GEN-LAST:event_refreshRegistryPageButtonActionPerformed

    private void pendingApprovalTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingApprovalTableMouseClicked
         selectedPendingApprovalIndex = pendingApprovalTable.getSelectedRow();                           
    }//GEN-LAST:event_pendingApprovalTableMouseClicked

    private void activateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activateButtonMouseClicked
        DefaultTableModel model = (DefaultTableModel)pendingApprovalTable.getModel();
        Integer emp_no=Integer.parseInt(model.getValueAt(selectedPendingApprovalIndex, 0).toString());
        String warningText ="Are you sure to activate employee "+ emp_no;
        int dialogResult = JOptionPane.showConfirmDialog(null, warningText,"Activate Employee alert",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){    
            if(selectedPendingApprovalIndex==null){
                JOptionPane.showMessageDialog(this,"Before activate account please select account first"); 
            }else{           
                employeeDao.accountActivator(emp_no, AccountStatus.Valid);
                refreshPendingApproveTable();
            }
        }
    }//GEN-LAST:event_activateButtonMouseClicked

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitButtonActionPerformed

    private void searchComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchComboBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchComboBoxMouseClicked

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        searchOnPendingApproval();
    }//GEN-LAST:event_searchButtonMouseClicked

    private void cancelEmployeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelEmployeeTableMouseClicked
        selectedCurrentEmployeeIndex=cancelEmployeeTable.getSelectedRow();
    }//GEN-LAST:event_cancelEmployeeTableMouseClicked

    private void currentEmployeeSearchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currentEmployeeSearchButtonMouseClicked
        searchCurrentEmployees();
    }//GEN-LAST:event_currentEmployeeSearchButtonMouseClicked

    private void revokeCurrentEmployeeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_revokeCurrentEmployeeButtonMouseClicked
        DefaultTableModel model= (DefaultTableModel) cancelEmployeeTable.getModel();
        Integer selectedEmpNo=Integer.parseInt(model.getValueAt(selectedCurrentEmployeeIndex, 0).toString());
        String selectedTitle=model.getValueAt(selectedCurrentEmployeeIndex,5).toString();
        String warningText ="Are you sure revoke Employee "+ selectedEmpNo;
        int dialogResult = JOptionPane.showConfirmDialog(null, warningText,"Revoke Employee alert",JOptionPane.YES_NO_OPTION);           
        if(dialogResult == JOptionPane.YES_OPTION){       
            if(selectedCurrentEmployeeIndex!=null){                
                if(selectedTitle.equals("Manager")){
                    employeeDao.revokeManagerGrade(selectedEmpNo);
                }            
                employeeDao.revokeEmployee(selectedEmpNo);
                employeeDao.revokeAccount(selectedEmpNo);
                employeeDao.revokeTitle(selectedEmpNo);
                refreshCurrentEmployeesTable();            
            }else{
                JOptionPane.showMessageDialog(this,"Before revoke a employee please select employee first"); 
            }
        }
    }//GEN-LAST:event_revokeCurrentEmployeeButtonMouseClicked

    private void refreshCurrentEmployeeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshCurrentEmployeeButtonMouseClicked
       refreshCurrentEmployeesTable();
       currentEmployeeSearchTextField.setText("");
    }//GEN-LAST:event_refreshCurrentEmployeeButtonMouseClicked
    
    private void searchOnPendingApproval(){
        String inputValue=searchTextField.getText();
        System.out.println("Input value on searchTextField is : " + inputValue);
        cleanTableModel(pendingApprovalTable);
        switch(searchComboBox.getSelectedIndex()){
            case 0: //All
                pendingApprovalTable.setModel(getAdminMainMenuTableModel(departmentDao.employeeInvalidAccount(SearchSelection.ALL,null)));
                break;
            case 1:// Emp No.                
                pendingApprovalTable.setModel(getAdminMainMenuTableModel(departmentDao.employeeInvalidAccount(SearchSelection.EMPLOYEE_NUMBER,inputValue)));
                break;
            case 2: // Depatment Name
                pendingApprovalTable.setModel(getAdminMainMenuTableModel(departmentDao.employeeInvalidAccount(SearchSelection.DEPARTMENT_NAME, inputValue)));
                break;
            case 3: //Department Number
                pendingApprovalTable.setModel(getAdminMainMenuTableModel(departmentDao.employeeInvalidAccount(SearchSelection.DEPARTMENT_NUMBER, inputValue)));
                break;
            case 4:  // Job Title
                pendingApprovalTable.setModel(getAdminMainMenuTableModel(departmentDao.employeeInvalidAccount(SearchSelection.JOB_TITLE, inputValue)));
                break;
            case 5: // Name
                pendingApprovalTable.setModel(getAdminMainMenuTableModel(departmentDao.employeeInvalidAccount(SearchSelection.EMPLOYEE_FULL_NAME, inputValue)));
                break;
            default: 
                System.out.println("What are you searching ?");
                break;
                
        }
    }
        
     private void searchCurrentEmployees(){
        String inputValue=currentEmployeeSearchTextField.getText();
        System.out.println("Input value on searchTextField is : " + inputValue);
        cleanTableModel(cancelEmployeeTable);
        switch(currentEmployeeSearchComboBox.getSelectedIndex()){
            case 0: //All
                cancelEmployeeTable.setModel(getAdminMainMenuTableModel(departmentDao.currentEmployeesList(SearchSelection.ALL, null)));
                break;
            case 1:// Emp No.               
                cancelEmployeeTable.setModel(getAdminMainMenuTableModel(departmentDao.currentEmployeesList(SearchSelection.EMPLOYEE_NUMBER,inputValue)));
                break;
            case 2: // Depatment Name               
                cancelEmployeeTable.setModel(getAdminMainMenuTableModel(departmentDao.currentEmployeesList(SearchSelection.DEPARTMENT_NAME, inputValue)));
                break;
            case 3: //Department Number
                cancelEmployeeTable.setModel(getAdminMainMenuTableModel(departmentDao.currentEmployeesList(SearchSelection.DEPARTMENT_NUMBER, inputValue)));
                break;
            case 4:  // Job Title
                cancelEmployeeTable.setModel(getAdminMainMenuTableModel(departmentDao.currentEmployeesList(SearchSelection.JOB_TITLE, inputValue)));
                break;
            case 5: // Name
                cancelEmployeeTable.setModel(getAdminMainMenuTableModel(departmentDao.currentEmployeesList(SearchSelection.EMPLOYEE_FULL_NAME, inputValue)));
                break;
            default: 
                System.out.println("What are you searching ?");
                break;
        }  
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activateButton;
    private com.toedter.calendar.JDateChooser birthDateChooser;
    private javax.swing.JLabel birthDateLabel;
    private javax.swing.JTable cancelEmployeeTable;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton currentEmployeeSearchButton;
    private javax.swing.JComboBox<String> currentEmployeeSearchComboBox;
    private javax.swing.JTextField currentEmployeeSearchTextField;
    private javax.swing.JComboBox<String> departmentComboBox;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.ButtonGroup genderButtonGroup;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jobTitleLabel;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton logoutButton;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JTable pendingApprovalTable;
    private javax.swing.JButton personalInfoButton;
    private javax.swing.JButton refreshCurrentEmployeeButton;
    private javax.swing.JButton refreshRegistryPageButton;
    private javax.swing.JButton revokeCurrentEmployeeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> searchComboBox;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton submitButton;
    private javax.swing.JComboBox<String> titleComboBox;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JLabel warningLabel;
    private javax.swing.JLabel warningLabel1;
    private javax.swing.JLabel warningLabel2;
    private javax.swing.JLabel warningLabel3;
    private javax.swing.JLabel warningLabel4;
    private javax.swing.JLabel warningLabel5;
    private javax.swing.JLabel warningLabel6;
    private javax.swing.JLabel warningLabel7;
    // End of variables declaration//GEN-END:variables
}

