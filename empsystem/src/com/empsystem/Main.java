/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem;

import com.empsystem.dao.Database;
import com.empsystem.ui.frame.MainFrame;
import com.empsystem.util.Config;
import java.io.IOException;


/**
 *
 * @author Michael
 */
public class Main {
    public static void main(String[] args) throws IOException{
        //Get username , password, db_url from file
        Config config=new Config("com\\empsystem\\resources\\DB_Config.cfg");       
        String username=config.getProperty("username");
        String password=config.getProperty("password");
        String db_url=config.getProperty("database_url");
        //Connect db
        Database db= new Database();
        db.setDatabase(username, password, db_url);       
        if(db.connect()){
            MainFrame mainFrame=new MainFrame();
            mainFrame.getMainFrame();
        }else{
            System.out.println("Database connect failed");
        }
    }    
}












































































































