    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empsystem.dao;

import com.empsystem.entity.Department;
import java.util.ArrayList;
import java.util.HashMap;
import com.empsystem.entity.SearchSelection;

/**
 *
 * @author Michael
 */
public interface DepartmentDao {
    ArrayList<Department> underYourDeptList();
    ArrayList<Department> departmentMembersList(String department_number, SearchSelection selection, String searchValue);
    HashMap<Integer, Integer> currentPartakeCount();
    HashMap<Integer, Integer> totalPartakeCount();
    HashMap<Integer, Department> employeeHighTitle();
    ArrayList<Department> getDepartmentList();
    ArrayList<Department> employeeInvalidAccount(SearchSelection selection, String searchValue );// All
    ArrayList<Department> currentEmployeesList(SearchSelection selection, String searchValue);// Admin
    
}
























