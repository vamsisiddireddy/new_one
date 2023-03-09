package com.lira.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lira.dao.EmployeeDAO;
import com.lira.entity.Employee;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	@Autowired	
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO=employeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		System.out.println("in employeeServiceImpl findAll method");
		return employeeDAO.findAll();
		
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.delete(theId);

	}
	
	@Override
	@Transactional
	public HashMap<Integer,String> findByRole(String theRole)
	{
		List<Employee> emploees = employeeDAO.findAll();
		HashMap<Integer,String> empByRole = new HashMap<>();
		for(int i=0; i<emploees.size(); i++) {
			String name = null;
			int id;
			if(emploees.get(i).getRole().equals(theRole))
			{
				    id=emploees.get(i).getEmpId();
					name = emploees.get(i).getFirstName()+" "+emploees.get(i).getLastName();
					empByRole.put(id,name);
					
			}
	    }
		
		return empByRole;
	}

}
