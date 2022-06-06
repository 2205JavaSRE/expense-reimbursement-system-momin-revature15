package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {
	
	
	public void createReimbursement(Reimbursement r);
	
	public List <Reimbursement> viewPastTickets(int employee_id);

	public List<Reimbursement> pendingRequest(int employee_id);

	public List<Reimbursement> allReimbursementRequests();
}	
