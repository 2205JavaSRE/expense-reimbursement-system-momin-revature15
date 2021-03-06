package com.revature.controller;

import java.util.List;

import org.eclipse.jetty.http.HttpStatus;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;

import io.javalin.http.Context;

public class ReimbursementController 
{
	private static EmployeeDao empl = new EmployeeDaoImpl();
	private static ReimbursementDao reDao = new ReimbursementDaoImpl();
	
	public static void submitRequest(Context ctx) {
	
	
	Employee emp = AuthenticateController.verify(ctx);
	
	if(emp!=null)
		
	{
	String sA = ctx.formParam("amount");
	int amount = Integer.parseInt(sA);
    String reimbursement_type = ctx.formParam("reimbursement_type");
    
    Reimbursement r = new Reimbursement(-1,amount,reimbursement_type,"pending",emp.getEmployee_id());
    
   reDao.createReimbursement(r);
    
	}
	else {
		
	}
	ctx.result("login first.");
	ctx.status(HttpStatus.FORBIDDEN_403);
	
	
	}

	public static void viewPastTickets(Context ctx) {
		Employee emp = AuthenticateController.verify(ctx);
		if(emp!=null) {
			
		              List <Reimbursement> reimbursementList = reDao.viewPastTickets(emp.getEmployee_id());
		              ctx.json(reimbursementList);
			
		}
		
		 else {
	            ctx.result("invalid credentials.");
	            ctx.status(HttpStatus.FORBIDDEN_403);
	        }
		
	}
	
	
	public static void viewPendingRequest(Context ctx) {
		Employee emp = AuthenticateController.verify(ctx);
		if(emp!=null) {
			
		              List <Reimbursement> reimbursementPendingList = reDao.pendingRequest(emp.getEmployee_id());
		              ctx.json(reimbursementPendingList);
			
		}
		
		 else {
	            ctx.result("invalid credentials.");
	            ctx.status(HttpStatus.FORBIDDEN_403);
	        }
		
	}
	
	
	public static void allReimbursementRequests(Context ctx) {
		
		Employee manager = AuthenticateController.verifyM(ctx);
		
		if(manager!=null) {
			List <Reimbursement> reimbursementList = reDao.allReimbursementRequests();
			ctx.json(reimbursementList);
		}
		else {
			ctx.result("invalid credentials.");
            ctx.status(HttpStatus.FORBIDDEN_403);
			
		}
	}
	 
	public static void updateStatus(Context ctx) {
		
		Employee manager = AuthenticateController.verifyM(ctx);
		
		if(manager!=null) {
			
			String id = ctx.formParam("reimbursement_id");
		    String status = ctx.formParam("status");
            int reID = Integer.parseInt(id);
            
            reDao.updateStatus(reID, status);
            ctx.result("Update Successfully");
         }
		
		else {
			ctx.result("Please login first");
			ctx.status(HttpStatus.FORBIDDEN_403);
		}
		
	}
	
	public static void viewPastEmployeeHistory(Context ctx){
		
		
        Employee manager = AuthenticateController.verifyM(ctx);
		
		if(manager!=null) {
			
		String employee_id = ctx.formParam("employee_id");
		 int eID = Integer.parseInt(employee_id);
		List <Reimbursement> reimbursementList = reDao.getReimbursementById(eID);
		ctx.json(reimbursementList);
		
	}
		else {
			ctx.result("login first");
			ctx.status(HttpStatus.FORBIDDEN_403);
		}
		
	}
}
