/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.util;


import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;
/**
 *
 * @author Michael
 */
public class Config{
    private Properties configFile;
    private InputStream inputStream;

    public Config(String filePath) throws IOException{
        try{
            configFile = new Properties(); 
            inputStream =getClass().getClassLoader().getResourceAsStream(filePath);
            configFile.load(inputStream);

            inputStream.close();
        }catch(Exception e){        
            e.printStackTrace();
        }
    }

    public String getProperty(String key){
    String value = this.configFile.getProperty(key);
    return value;
    }
}


























































































































