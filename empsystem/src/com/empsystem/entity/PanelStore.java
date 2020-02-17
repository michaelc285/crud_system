/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.entity;

import com.empsystem.ui.BasePanel;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;


/**
 *  panel (component, name)stored in cardLayout 
 *  cardLayout call panel by(Container, JPanel extending BasePanel.class)
 * 
 *  @author Michael
 */
public class PanelStore {
    
    private Map<String,BasePanel> panelMap; // Basepanel.setupPage();
    private JPanel panel;
    private CardLayout cardLayout;
    
    
    public PanelStore(JPanel panel, CardLayout layout){
        panelMap=new HashMap<>();
        this.panel = panel;
        this.cardLayout = layout;        
    }
    
    public void setPanel(String name,BasePanel inputPanel){
        this.panelMap.put(name, inputPanel);
        this.panel.add(name, inputPanel);
    }
    
    public BasePanel getPanel(String name){
        System.out.println("Panel called "+name);
        return panelMap.get(name);
    }
               
    public void showJPanel(String name){
        System.out.println("Panel show "+name);
        getPanel(name).setupPage();
        cardLayout.show(panel,name); //cardLayout.show(Container = JPanel panel, String name);
    }
}
    












