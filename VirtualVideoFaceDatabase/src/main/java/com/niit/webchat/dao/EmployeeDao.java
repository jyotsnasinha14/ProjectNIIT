package com.niit.webchat.dao;

import java.util.List;

import com.niit.webchat.model.Employee;

public interface EmployeeDao {
	boolean addUser(Employee employee);

	public boolean deleteUser(Employee employee);

	boolean updateUser(Employee employee);

	public Employee getUserById(int userId);

	public List<Employee> getAllUser();

	public Employee getUserEmail(String emailId);
	
	boolean updatePassword(Employee employee);

}
