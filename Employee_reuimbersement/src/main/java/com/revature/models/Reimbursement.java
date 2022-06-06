package com.revature.models;

public class Reimbursement {
private int reimbursement_id;
private int amount;
private String reimbursement_type;
private String isRequest;
private int Employee_id;

public int getReimbursement_id() {
	return reimbursement_id;
}
public Reimbursement(int reimbursement_id, int amount, String reimbursement_type, String isRequest, int employee_id) {
	super();
	this.reimbursement_id = reimbursement_id;
	this.amount = amount;
	this.reimbursement_type = reimbursement_type;
	this.isRequest = isRequest;
	Employee_id = employee_id;
}
public void setReimbursement_id(int reimbursement_id) {
	this.reimbursement_id = reimbursement_id;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public String getIsRequest() {
	return isRequest;
}
public void setIsRequest(String isRequest) {
	this.isRequest = isRequest;
}
public String getReimbursement_type() {
	return reimbursement_type;
}
public void setReimbursement_type(String reimbursement_type) {
	this.reimbursement_type = reimbursement_type;
}
public int getEmployee_id() {
	return Employee_id;
}
public void setEmployee_id(int employee_id) {
	Employee_id = employee_id;
}

}
