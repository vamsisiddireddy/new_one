package com.lira.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lira.entity.RecReport;

@Service
public class RecReportDAOImpl implements RecReportDAO{

	private EntityManager entityManager;
	
	
	@Autowired
	public RecReportDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	public RecReportDAOImpl() {
		
	}
	
	
	@Override
	public List<RecReport> findAll() {
		System.out.println("in RecReportDAOImpl findAll");
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<RecReport> theQuery = currentSession.createQuery(" from RecReportDAOImpl", RecReport.class);
		List<RecReport> emreports=theQuery.getResultList();
		System.out.println("in EMReportDAOImpl findAll" +emreports.toString() );
		return emreports;
	}

	@Override
	public RecReport findById(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		RecReport theRecReport = currentSession.get(RecReport.class, theId);
				
		return theRecReport;
	}

	@Override
	public void save(RecReport theRecReport) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theRecReport);
		
	}

	@Override
	public void delete(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery(" delete from theRecReport where report_id= :report_id");
		theQuery.setParameter("report_id", theId);
		theQuery.executeUpdate();
		
	}
	
}
