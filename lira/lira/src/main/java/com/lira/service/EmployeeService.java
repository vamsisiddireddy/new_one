package com.lira.service;

import java.util.HashMap;
import java.util.List;

import com.lira.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
	public HashMap<Integer,String> findByRole(String theRole);

}
