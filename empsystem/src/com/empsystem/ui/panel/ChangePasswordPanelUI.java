/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.ui.panel;

import com.empsystem.entity.PanelStore;
import com.empsystem.ui.BasePanel;
import static com.empsystem.ui.PanelConstant.PERSONAL_INFO;

/**
 *
 * @author Michael
 */
public class ChangePasswordPanelUI extends BasePanel {
    
    /**
     * Creates new form SubPanelChangePassword
     * @param ps
     */
    public ChangePasswordPanelUI(PanelStore ps) {
        super(ps);     
    }
    
    
    @Override
    public void init() {
        initComponents();
    }

    @Override
    public void setupPage() {
        originalPasswordField.setText("");
        newPasswordField.setText("");
        reNewPasswordField.setText("");
        
        warningLabel1.setVisible(false);
        warningLabel2.setVisible(false);
        warningLabel3.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        originalPaswwordLabel = new javax.swing.JLabel();
        newPasswordLabel = new javax.swing.JLabel();
        originalPasswordField = new javax.swing.JPasswordField();
        newPasswordField = new javax.swing.JPasswordField();
        reNewPasswordField = new javax.swing.JPasswordField();
        reNewPasswordLabel = new javax.swing.JLabel();
        enterButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        warningLabel1 = new javax.swing.JLabel();
        warningLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        warningLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Change Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        setMaximumSize(new java.awt.Dimension(451, 413));
        setMinimumSize(new java.awt.Dimension(451, 413));
        setPreferredSize(new java.awt.Dimension(451, 413));

        originalPaswwordLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        originalPaswwordLabel.setText("Original Password");

        newPasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        newPasswordLabel.setText("New Password");

        originalPasswordField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        originalPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                originalPasswordFieldActionPerformed(evt);
            }
        });

        newPasswordField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        newPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPasswordFieldActionPerformed(evt);
            }
        });

        reNewPasswordField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        reNewPasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        reNewPasswordLabel.setText("Re-New Password");

        enterButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enterButton.setText("Enter");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        warningLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        warningLabel1.setForeground(new java.awt.Color(255, 102, 102));
        warningLabel1.setText("Invalid original password. ");

        warningLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        warningLabel2.setForeground(new java.awt.Color(255, 102, 102));
        warningLabel2.setText("Invalid password pattern. *");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("*Password Rules:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Must have at least one uppercase character");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Must have at least one lowercase character");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Length 6-16");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Only accept a-z, A-Z,  0-9,  !@#$%^&*");

        warningLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        warningLabel3.setForeground(new java.awt.Color(255, 102, 102));
        warningLabel3.setText("Those passwords didn't match.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(enterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newPasswordLabel)
                            .addComponent(originalPaswwordLabel)
                            .addComponent(reNewPasswordLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(warningLabel1)
                            .addComponent(warningLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(originalPasswordField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                .addComponent(warningLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(reNewPasswordField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(newPasswordField, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(originalPaswwordLabel)
                    .addComponent(originalPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(warningLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPasswordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reNewPasswordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningLabel3)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterButton)
                    .addComponent(cancelButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        ps.showJPanel(PERSONAL_INFO);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void originalPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_originalPasswordFieldActionPerformed
        
    }//GEN-LAST:event_originalPasswordFieldActionPerformed

    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed
        String originalPassword = String.valueOf(originalPasswordField.getPassword());
        String newPassword = String.valueOf(newPasswordField.getPassword());
        String reNewPassword=String.valueOf(reNewPasswordField.getPassword());
        
        boolean checkOrginalPassword = checkOriginalPassword(originalPassword);
        boolean passwordPattern=employeeDao.passwordPattern(newPassword);
        boolean doubleValidation=employeeDao.passwordDoubleValidation(newPassword, reNewPassword);
        
        if(!checkOrginalPassword)warningLabel1.setVisible(true);
        if(!passwordPattern)warningLabel2.setVisible(true);      
        if(!doubleValidation)warningLabel3.setVisible(true);
            
        if(checkOrginalPassword && passwordPattern && doubleValidation){
            String username = loginEmployee.getUsername();          
            if(employeeDao.changePassword(username, newPassword)){
                loginEmployee.setPassword(newPassword); //Update loginEmployee password attribute
                setupPage();
                //System.out.println("Login Employee Info update Succed new Password: " + getLoginEmployee().getPassword());
            }else{
                //System.out.println("Database side update fail!!!");
            }
        }        
    }//GEN-LAST:event_enterButtonActionPerformed

    private void newPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPasswordFieldActionPerformed
    private boolean checkOriginalPassword(String orginalPassword){        
        if(!loginEmployee.getPassword().equals(orginalPassword)){           
            System.out.println("Original password invalid");
            return false;
        }
        System.out.println("Original password Correct");
        return true;
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton enterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JLabel newPasswordLabel;
    private javax.swing.JPasswordField originalPasswordField;
    private javax.swing.JLabel originalPaswwordLabel;
    private javax.swing.JPasswordField reNewPasswordField;
    private javax.swing.JLabel reNewPasswordLabel;
    private javax.swing.JLabel warningLabel1;
    private javax.swing.JLabel warningLabel2;
    private javax.swing.JLabel warningLabel3;
    // End of variables declaration//GEN-END:variables
}
