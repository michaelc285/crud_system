/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.ui.frame;

import com.empsystem.entity.PanelStore;
import com.empsystem.ui.BasePanel;
import com.empsystem.ui.panel.PersonalInfoPanelUI;
import com.empsystem.ui.panel.ChangePasswordPanelUI;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static com.empsystem.ui.PanelConstant.*;

/**
 *
 * @author Michael
 */
public class SubFrame{    
    
    public void showSubPanelUI(){
        //Create Sub JFrame
        JFrame subFrame = new JFrame("Employee System");
        
        //Create JPanel to contain the CardLayout
        JPanel containerPanel = new JPanel(); // The container
        subFrame.add(containerPanel);
        
        //Create CardLayout
        CardLayout cardLayout = new CardLayout();
        cardLayout.setHgap(10);
        cardLayout.setVgap(10);
        
        containerPanel.setLayout(cardLayout);
        
        //Create PanelStore
        PanelStore ps=new PanelStore(containerPanel,cardLayout);
        
        //Create and put Panel UI into PanelStore
        BasePanel PersonalInfoPanelUI=new PersonalInfoPanelUI(ps);
        ps.setPanel(PERSONAL_INFO, PersonalInfoPanelUI);
        
        BasePanel subPanelChangePasswordPanelUI=new ChangePasswordPanelUI(ps);
        ps.setPanel(CHANGE_PASSWORD,subPanelChangePasswordPanelUI);
        
        //Show Login_Panel on mainFrame
        ps.showJPanel(PERSONAL_INFO);
        
        subFrame.setResizable(false);
        subFrame.pack();        
        subFrame.setVisible(true);
        
        // center the jframe on screen
        subFrame.setLocationRelativeTo(null);         
    }
  
}







