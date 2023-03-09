package com.lira.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lira.entity.EMReport;

@Service
public class EMReportDAOImpl implements EMReportDAO{

	private EntityManager entityManager;
	
	
	@Autowired
	public EMReportDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	public EMReportDAOImpl() {
		
	}
	
	
	@Override
	public List<EMReport> findAll() {
		System.out.println("in EMReportDAOImpl findAll");
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<EMReport> theQuery = currentSession.createQuery(" from EMReportDAOImpl", EMReport.class);
		List<EMReport> emreports=theQuery.getResultList();
		System.out.println("in EMReportDAOImpl findAll" +emreports.toString() );
		return emreports;
	}

	@Override
	public EMReport findById(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		EMReport theEMReport = currentSession.get(EMReport.class, theId);
				
		return theEMReport;
	}

	@Override
	public void save(EMReport theEMReport) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEMReport);
		
	}

	@Override
	public void delete(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery(" delete from Employee where report_id= :report_id");
		theQuery.setParameter("report_id", theId);
		theQuery.executeUpdate();
		
	}
	
}
