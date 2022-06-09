package com.revature.controller;

import org.eclipse.jetty.http.HttpStatus;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.models.Employee;


import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class AuthenticateController {
	private static EmployeeDao empl = new EmployeeDaoImpl();
		
	public static void authentitcateEmployee(Context ctx)
	{
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		
		Employee employee = empl.verifyEmployee(username,password);
		
		if(employee !=null)
		{
			System.out.println("Login Successfull");
			
			ctx.result("Login Successfull");
			
			ctx.sessionAttribute("Employee",employee);
			
			ctx.status(HttpStatus.ACCEPTED_202);
			
		}
		
		
		else {
			
			System.out.println("Invalid username or password");
			ctx.result("invalid username or password");
			ctx.status(HttpCode.FORBIDDEN);
		}
		
	}
	 
	
	public static Employee verify(Context ctx) {

	        Employee employee = ctx.sessionAttribute("Employee");

	        if (employee == null) { 
	        return null;
	        }
	        else { 
	        	
	        	return employee;
	    }
	        }
	
	public static void authentitcateManager(Context ctx)
	{
		EmployeeDao emp = new EmployeeDaoImpl();
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		
		Employee manager = emp.verifyManager(username,password);
		
		if(manager !=null)
		{
			System.out.println("Login Successfull");
			ctx.result("you have access");
			ctx.sessionAttribute("Manager",manager);
			ctx.sessionAttribute("role","master");
			ctx.status(HttpStatus.ACCEPTED_202);
			
		}
		
		
		else {
			
			System.out.println("Invalid username or password");
			ctx.result("invalid username or password");
			ctx.status(HttpCode.FORBIDDEN);
		}
		
	}
	
	public static Employee verifyM(Context ctx) {

        Employee manager = ctx.sessionAttribute("Manager");

        if (manager == null) { 
        return null;
        }
        else { 
        	
        	return manager;
    }
        }
		
		
	public static void logoutE(Context ctx) {
		Employee employee = AuthenticateController.verify(ctx);
		if(employee !=null)
		{
		ctx.consumeSessionAttribute("Employee");
		ctx.result("Logout successful.");
	}
		else {
			
			ctx.result("no session to consume");
		}
	}
public static void logoutM(Context ctx) {
		
		ctx.consumeSessionAttribute("Manager");
		ctx.result("Logout successful.");
	}

	

}
