/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.ui.panel;

import com.empsystem.entity.PanelStore;
import com.empsystem.ui.BasePanel;
import static com.empsystem.ui.PanelConstant.CHANGE_PASSWORD;

/**
 *
 * @author Michael
 */
public class PersonalInfoPanelUI extends BasePanel {
    
    /**
     * Creates new form PersonalInfoPanelUI
     * @param ps
     */
    public PersonalInfoPanelUI(PanelStore ps) {
        super(ps);
    }
    
    @Override
    public void init() {
        initComponents();
    }

    @Override
    public void setupPage() {
        employeeNoResultLabel.setText(""+loginEmployee.getEmployee_no());
        firstNameResultLabel.setText(""+loginEmployee.getFirst_name());
        lastNameResultLabel.setText(""+loginEmployee.getLast_name());
        titleResultLabel.setText(""+loginEmployee.getTitle());
        hireDateResultLabel.setText(""+loginEmployee.getHire_date());
        deptNameResultLabel.setText(""+loginEmployee.getDeparment_name());
        loginNameResultLabel.setText(""+loginEmployee.getUsername());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstNameLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        employeeNoLabel = new javax.swing.JLabel();
        deptNameLabel = new javax.swing.JLabel();
        hireDateLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        birthDateLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        employeeNoResultLabel = new javax.swing.JLabel();
        firstNameResultLabel = new javax.swing.JLabel();
        lastNameResultLabel = new javax.swing.JLabel();
        titleResultLabel = new javax.swing.JLabel();
        hireDateResultLabel = new javax.swing.JLabel();
        deptNameResultLabel = new javax.swing.JLabel();
        loginNameLabel = new javax.swing.JLabel();
        loginNameResultLabel = new javax.swing.JLabel();
        pwChangeButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        setMaximumSize(new java.awt.Dimension(451, 413));
        setMinimumSize(new java.awt.Dimension(451, 413));
        setPreferredSize(new java.awt.Dimension(451, 413));

        firstNameLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        firstNameLabel.setText("First Name");

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        titleLabel.setText("Title ");

        employeeNoLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        employeeNoLabel.setText("Employee No.");

        deptNameLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        deptNameLabel.setText("Department");

        hireDateLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        hireDateLabel.setText("Hire Date");

        lastNameLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lastNameLabel.setText("Last Name");

        birthDateLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        employeeNoResultLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        employeeNoResultLabel.setText("Employee No. Result");

        firstNameResultLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        firstNameResultLabel.setText("First Name Result");

        lastNameResultLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lastNameResultLabel.setText("Last Name Result");

        titleResultLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        titleResultLabel.setText("Title Result ");

        hireDateResultLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        hireDateResultLabel.setText("Hire Date Result");

        deptNameResultLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        deptNameResultLabel.setText("Department Result");

        loginNameLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        loginNameLabel.setText("Login Name");

        loginNameResultLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        loginNameResultLabel.setText("Login Name Result");

        pwChangeButton.setText("Change Password");
        pwChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwChangeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(employeeNoLabel)
                        .addGap(123, 123, 123)
                        .addComponent(employeeNoResultLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstNameLabel)
                        .addGap(146, 146, 146)
                        .addComponent(firstNameResultLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameLabel)
                            .addComponent(jLabel9))
                        .addGap(148, 148, 148)
                        .addComponent(lastNameResultLabel))
                    .addComponent(birthDateLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(186, 186, 186)
                        .addComponent(titleResultLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hireDateLabel)
                        .addGap(156, 156, 156)
                        .addComponent(hireDateResultLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deptNameLabel)
                        .addGap(139, 139, 139)
                        .addComponent(deptNameResultLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginNameLabel)
                        .addGap(137, 137, 137)
                        .addComponent(loginNameResultLabel))
                    .addComponent(pwChangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeNoLabel)
                    .addComponent(employeeNoResultLabel))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameResultLabel))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastNameLabel)
                    .addComponent(jLabel9)
                    .addComponent(lastNameResultLabel))
                .addComponent(birthDateLabel)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(titleLabel))
                    .addComponent(titleResultLabel))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(hireDateLabel))
                    .addComponent(hireDateResultLabel))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(deptNameLabel))
                    .addComponent(deptNameResultLabel))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginNameLabel)
                    .addComponent(loginNameResultLabel))
                .addGap(115, 115, 115)
                .addComponent(pwChangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pwChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwChangeButtonActionPerformed
        ps.showJPanel(CHANGE_PASSWORD);
    }//GEN-LAST:event_pwChangeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel birthDateLabel;
    private javax.swing.JLabel deptNameLabel;
    private javax.swing.JLabel deptNameResultLabel;
    private javax.swing.JLabel employeeNoLabel;
    private javax.swing.JLabel employeeNoResultLabel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel firstNameResultLabel;
    private javax.swing.JLabel hireDateLabel;
    private javax.swing.JLabel hireDateResultLabel;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel lastNameResultLabel;
    private javax.swing.JLabel loginNameLabel;
    private javax.swing.JLabel loginNameResultLabel;
    private javax.swing.JButton pwChangeButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel titleResultLabel;
    // End of variables declaration//GEN-END:variables


}
