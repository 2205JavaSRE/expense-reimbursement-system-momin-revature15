package com.revature.service;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class EmployeeService {

	private static EmployeeDao eDao = new EmployeeDaoImpl();
	private static ReimbursementDao reDao = new ReimbursementDaoImpl();
	
	
}
