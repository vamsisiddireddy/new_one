package com.lira.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lira.entity.PyeReport;

@Service
public class PyeReportDAOImpl implements PyeReportDAO{

	private EntityManager entityManager;
	
	
	@Autowired
	public PyeReportDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	public PyeReportDAOImpl() {
		
	}
	
	
	@Override
	public List<PyeReport> findAll() {
		System.out.println("in PyeReportDAOImpl findAll");
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<PyeReport> theQuery = currentSession.createQuery(" from PyeReport", PyeReport.class);
		List<PyeReport> employees=theQuery.getResultList();
		System.out.println("in employeeDAOImpl findAll" +employees.toString() );
		return employees;
	}

	@Override
	public PyeReport findById(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		PyeReport thePyeReport = currentSession.get(PyeReport.class, theId);
				
		return thePyeReport;
	}

	@Override
	public void save(PyeReport thePyeReport) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(thePyeReport);
		
	}

	@Override
	public void delete(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery(" delete from Employee where report_id= :report_id");
		theQuery.setParameter("report_id", theId);
		theQuery.executeUpdate();
		
	}
	
}
