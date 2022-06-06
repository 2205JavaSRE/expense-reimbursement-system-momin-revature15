package com.revature.dao;

import com.revature.models.Employee;

public interface EmployeeDao {

	
	public Employee verifyEmployee(String username,String password);
	public Employee verifyManager(String username, String password);
	
}
