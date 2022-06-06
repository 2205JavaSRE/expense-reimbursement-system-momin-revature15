package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public Employee verifyEmployee(String username, String password) {
		String sql = "select * from employee where username = ? and password = ? and ismanager = ?";
		Connection connection = ConnectionFactory.getConnection();
		Employee employee = null;
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
            ps.setString(2, password);
            ps.setBoolean(3,false);
			ResultSet rs = 	ps.executeQuery();
			
			if(rs.next()) {
		     employee = new Employee( rs.getInt("employee_id"), rs.getString("name"), rs.getString("email"), rs.getString("username"), rs.getBoolean("isManager"), rs.getString("password"));
			return employee;			
			}	
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
           return null;
	
	}
	
	
	public Employee verifyManager(String username, String password) {
		String sql = "select * from employee where username = ? and password = ? and ismanager = ?";
		Connection connection = ConnectionFactory.getConnection();
		Employee manager = null;
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
            ps.setString(2, password);
            ps.setBoolean(3,true);
			ResultSet rs = 	ps.executeQuery();
			
			if(rs.next()) {
		     manager = new Employee( rs.getInt("employee_id"), rs.getString("name"), rs.getString("email"), rs.getString("username"), rs.getBoolean("isManager"), rs.getString("password"));
			return manager;			
			}	
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
           return null;
	
	}
}
