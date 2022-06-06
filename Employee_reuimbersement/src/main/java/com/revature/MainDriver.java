package com.revature;

import com.revature.controller.RequestMapper;

import io.javalin.Javalin;

public class MainDriver {

	
	public static void main(String[] args) {
		
		Javalin app = Javalin.create().start(7000);
       
		RequestMapper requestMapper = new RequestMapper();
		
		requestMapper.configureRoutes(app);
		

	}



}