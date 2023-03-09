package com.lira.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lira.entity.SelecReport;

@Service
public class SelecReportDAOImpl implements SelecReportDAO{

	private EntityManager entityManager;
	
	
	@Autowired
	public SelecReportDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	public SelecReportDAOImpl() {
		
	}
	
	
	@Override
	public List<SelecReport> findAll() {
		System.out.println("in SelecReportDAOImpl findAll");
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<SelecReport> theQuery = currentSession.createQuery(" from SelecReportDAOImpl", SelecReport.class);
		List<SelecReport> selecreports=theQuery.getResultList();
		System.out.println("in SelecReportDAOImpl findAll" +selecreports.toString() );
		return selecreports;
	}

	@Override
	public SelecReport findById(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		SelecReport theSelecReport = currentSession.get(SelecReport.class, theId);
				
		return theSelecReport;
	}

	@Override
	public void save(SelecReport theSelecReport) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theSelecReport);
		
	}

	@Override
	public void delete(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery(" delete from selec_report where report_id= :report_id");
		theQuery.setParameter("report_id", theId);
		theQuery.executeUpdate();
		
	}
	
}
