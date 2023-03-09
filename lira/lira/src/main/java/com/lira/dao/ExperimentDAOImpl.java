package com.lira.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lira.entity.Experiment;

@Service
public class ExperimentDAOImpl implements ExperimentDAO{

	private EntityManager entityManager;
	
	
	@Autowired
	public ExperimentDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	public ExperimentDAOImpl() {
		
	}
	
	
	@Override
	public List<Experiment> findAll() {
		System.out.println("in projectDAOImpl findAll");
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<Experiment> theQuery = currentSession.createQuery(" from Project", Experiment.class);
		List<Experiment> projects=theQuery.getResultList();
		System.out.println("in projectDAOImpl findAll" +projects.toString() );
		return projects;
	}

	@Override
	public Experiment findById(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Experiment theExperiment = currentSession.get(Experiment.class, theId);
				
		return theExperiment;
	}

	@Override
	public void save(Experiment theExperiment) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		currentSession.save(theExperiment);
		
	}

	@Override
	public void delete(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery(" delete from Experiment where id= :experiment_id");
		theQuery.setParameter("experiment_id", theId);
		theQuery.executeUpdate();
		
	}
	
	
		
	}
	


