package com.lira.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lira.entity.Project;

@Service
public class ProjectDAOImpl implements ProjectDAO{

	private EntityManager entityManager;
	
	
	@Autowired
	public ProjectDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	public ProjectDAOImpl() {
		
	}
	
	
	@Override
	public List<Project> findAll() {
		System.out.println("in projectDAOImpl findAll");
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<Project> theQuery = currentSession.createQuery(" from Project", Project.class);
		List<Project> projects=theQuery.getResultList();
		System.out.println("in projectDAOImpl findAll" +projects.toString() );
		return projects;
	}

	@Override
	public Project findById(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Project theEmployee = currentSession.get(Project.class, theId);
				
		return theEmployee;
	}

	@Override
	public void save(Project theProject) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		currentSession.save(theProject);
		
	}

	@Override
	public void delete(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery(" delete from Project where id= :projectId");
		theQuery.setParameter("projectId", theId);
		theQuery.executeUpdate();
		
	}
	
	@Override
	public List<Project> findByStatus(String theStatus){
		System.out.println("in projectDAOImpl findByStatus");
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<Project> theQuery = currentSession.createQuery(" from Project where status = :status", Project.class);
		theQuery.setParameter("status", theStatus);
		List<Project> projects=theQuery.getResultList();
		System.out.println("in projectDAOImpl findByStatus" +projects.toString() );
		return projects;
		
	}
	
}

