/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.util;


import com.empsystem.entity.AccountStatus;
import com.empsystem.entity.SearchSelection;
/**
 *
 * @author Michael
 */
public class Converter {
    public static String statusToString(AccountStatus status){        
        switch(status){
            case Valid:
                return "valid";             
            default:
                return "Invalid";
        }
    }
    
   
}



























