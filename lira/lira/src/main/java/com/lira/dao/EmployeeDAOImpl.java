package com.lira.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lira.entity.Employee;

@Service
public class EmployeeDAOImpl implements EmployeeDAO{

	private EntityManager entityManager;
	
	
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	public EmployeeDAOImpl() {
		
	}
	
	
	@Override
	public List<Employee> findAll() {
		System.out.println("in employeeDAOImpl findAll");
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery(" from Employee", Employee.class);
		List<Employee> employees=theQuery.getResultList();
		System.out.println("in employeeDAOImpl findAll" +employees.toString() );
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Employee theEmployee = currentSession.get(Employee.class, theId);
				
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void delete(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery(" delete from Employee where id= :employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
	}
	
}
