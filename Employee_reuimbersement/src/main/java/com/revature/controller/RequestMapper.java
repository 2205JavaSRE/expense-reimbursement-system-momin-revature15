package com.revature.controller;	


import io.javalin.Javalin;
import io.javalin.http.HttpCode;

public class RequestMapper {

	
	public void configureRoutes(Javalin app) {
	
		app.get("/greetings", ctx -> {ctx.result("Employee Reimbursement Application");});
		
		app.post("/login",ctx->{
			AuthenticateController.authentitcateEmployee(ctx);
		});
		
		app.post("/managerlogin",ctx->{
			AuthenticateController.authentitcateManager(ctx);
		});
		
		 app.get("/logout", ctx -> {
	            AuthenticateController.logout(ctx);
	        });
		 
		 app.post("/submitRequest", ctx->{
			 
			ReimbursementController.submitRequest(ctx);		
			 
		 });

		 app.get("/pastTickets", ctx->{
			 
			 ReimbursementController.viewPastTickets(ctx);
		 });
		 
		 app.get("/pendingRequests", ctx->{
			
			 ReimbursementController.viewPendingRequest(ctx);	
			 
		 });
		 
		 app.get("/allReimbursementRequests",ctx->{
			 
			ReimbursementController.allReimbursementRequests(ctx); 
		 });
 }
	
	
	

}
