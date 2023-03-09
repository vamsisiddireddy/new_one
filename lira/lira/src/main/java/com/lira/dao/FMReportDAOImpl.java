package com.lira.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lira.entity.FMReport;

@Service
public class FMReportDAOImpl implements FMReportDAO{

	private EntityManager entityManager;
	
	
	@Autowired
	public FMReportDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	public FMReportDAOImpl() {
		
	}
	
	
	@Override
	public List<FMReport> findAll() {
		System.out.println("in EMReportDAOImpl findAll");
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<FMReport> theQuery = currentSession.createQuery(" from FMReportDAOImpl", FMReport.class);
		List<FMReport> fmreports=theQuery.getResultList();
		System.out.println("in EMReportDAOImpl findAll" +fmreports.toString() );
		return fmreports;
	}

	@Override
	public FMReport findById(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		FMReport theFMReport = currentSession.get(FMReport.class, theId);
				
		return theFMReport;
	}

	@Override
	public void save(FMReport theFMReport) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theFMReport);
		
	}

	@Override
	public void delete(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery(" delete from FMReport where report_id= :report_id");
		theQuery.setParameter("report_id", theId);
		theQuery.executeUpdate();
		
	}
	
}
