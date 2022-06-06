package com.revature.models;

public class Employee {
private int employee_id;
private String name;
private String username;
private String email;
private boolean isManager;
private String password;


public Employee(int employee_id, String name, String username,String email, boolean isManager, String password) {
	super();
	this.employee_id = employee_id;
	this.name = name;
	this.username = username;
	this.email = email;
	this.isManager = isManager;
	this.password = password;
}
public int getEmployee_id() {
	return employee_id;
}
public void setEmployee_id(int employee_id) {
	this.employee_id = employee_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public boolean isManager() {
	return isManager;
}
public void setManager(boolean isManager) {
	this.isManager = isManager;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
}
