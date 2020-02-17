/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.ui.frame;

import com.empsystem.entity.PanelStore;
import com.empsystem.ui.BasePanel;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static com.empsystem.ui.PanelConstant.*;
import com.empsystem.ui.panel.LoginPanelUI;
import com.empsystem.ui.panel.admin.AdminMainPanelUI;
import com.empsystem.ui.panel.manager.EditProjectPanelUI;
import com.empsystem.ui.panel.manager.ManagerMainPanelUI;
import com.empsystem.ui.panel.staff.StaffMainPanelUI;

/**
 *
 * @author Michael
 */
public class MainFrame{    
    public void getMainFrame(){
        //Create Sub JFrame
        JFrame mainFrame = new JFrame("Employee System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create JPanel to contain the CardLayout
        JPanel containerPanel = new JPanel(); // The container
        mainFrame.add(containerPanel);
        
        //Create CardLayout
        CardLayout cardLayout = new CardLayout();
        cardLayout.setHgap(5);
        cardLayout.setVgap(5);
        
        containerPanel.setLayout(cardLayout);
        
        //Create PanelStore
        PanelStore ps=new PanelStore(containerPanel,cardLayout);
        
        //Create and put Panel UI into PanelStore
        BasePanel adminMainPanelUI = new AdminMainPanelUI(ps);
        ps.setPanel(ADMIN_MAIN, adminMainPanelUI);
        
        BasePanel managerMainPanelUI = new ManagerMainPanelUI(ps);
        ps.setPanel(MANAGER_MAIN, managerMainPanelUI);
        
        BasePanel staffMainPanelUI = new StaffMainPanelUI(ps);
        ps.setPanel(STAFF_MAIN, staffMainPanelUI);
        
        BasePanel editProjectPanelUI = new EditProjectPanelUI(ps);
        ps.setPanel(MANAGER_EDIT_PROJECT, editProjectPanelUI);
        
        BasePanel loginPanelUI = new LoginPanelUI(ps);
        ps.setPanel(LOGIN_PANEL, loginPanelUI);
        
        //Show Login_Panel on mainFrame
        ps.showJPanel(LOGIN_PANEL);
        

        
        mainFrame.setResizable(false);
        mainFrame.pack();        
        mainFrame.setVisible(true);
        
        // center the jframe on screen
        mainFrame.setLocationRelativeTo(null);
    }   
}



















































