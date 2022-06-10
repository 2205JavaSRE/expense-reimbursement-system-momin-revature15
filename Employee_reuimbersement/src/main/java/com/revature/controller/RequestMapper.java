package com.revature.controller;	
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;


import io.javalin.Javalin;
import io.javalin.http.HttpCode;
import io.micrometer.core.instrument.Counter;

public class RequestMapper {

	
	public void configureRoutes(Javalin app) {
	
		app.get("/greetings", ctx -> {ctx.result("Employee Reimbursement Application");});
		
		app.post("/login",ctx->{
			AuthenticateController.authentitcateEmployee(ctx);
		});
		
		app.post("/managerlogin",ctx->{
			AuthenticateController.authentitcateManager(ctx);
		});
		
		 app.get("/logoutE", ctx -> {
	            AuthenticateController.logoutE(ctx);
	        });
		 
		 app.get("/logoutM", ctx -> {
	            AuthenticateController.logoutM(ctx);
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
		 
		 app.post("/updateStatus",ctx->{
			 
				ReimbursementController.updateStatus(ctx);
			 });
 
		 app.get("/viewPastHistoryEmployees",ctx->{
			
			 ReimbursementController.viewPastEmployeeHistory(ctx);
			 
			 });
		 
	}
	

	}
