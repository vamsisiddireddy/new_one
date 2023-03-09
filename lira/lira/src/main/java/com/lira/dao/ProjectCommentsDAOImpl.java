package com.lira.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lira.entity.ProjectComments;

@Service
public class ProjectCommentsDAOImpl implements ProjectCommentsDAO{

	private EntityManager entityManager;


	@Autowired
	public ProjectCommentsDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}

	public ProjectCommentsDAOImpl() {

	}


	@Override
	public List<ProjectComments> findAll() {
		System.out.println("in ProjectCommentsDAOImpl findAll");
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<ProjectComments> theQuery = currentSession.createQuery(" from ProjectComments", ProjectComments.class);
		List<ProjectComments> projectComments=theQuery.getResultList();
		System.out.println("in ProjectCommentsDAOImpl findAll" +projectComments.toString() );
		return projectComments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectComments> findById(int theId) {

		Session currentSession =  entityManager.unwrap(Session.class);
		List<ProjectComments> projectComments = (List<ProjectComments>) currentSession.get(ProjectComments.class, theId);
		//Query<ProjectComments> theQuery = currentSession.createQuery("from ProjectComments u where u.proj_id=:projectId", ProjectComments.class);
		//theQuery.setParameter("projectId", theId);
		//List<ProjectComments> projectCommentslist=theQuery.getResultList();
		return projectComments;
		
	}


	@Override
	public List<ProjectComments> findByProjId(int theProjId) {

		Session currentSession =  entityManager.unwrap(Session.class);
		//List<ProjectComments> projectComments = (List<ProjectComments>) currentSession.get(ProjectComments.class, theProjId);
		Query<ProjectComments> theQuery = currentSession.createQuery("from ProjectComments u where u.proj_id=:projectId", ProjectComments.class);
		theQuery.setParameter("projectId", theProjId);
		List<ProjectComments> projectCommentslist=theQuery.getResultList();
		return projectCommentslist;
		
	}
	
	@Override
	public void save(ProjectComments projectComments) {

		Session currentSession =  entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(projectComments);

	}

//	@Override
//	public void delete(int theId) {
//
//		Session currentSession =  entityManager.unwrap(Session.class);
//
//		Query theQuery = currentSession.createQuery(" delete from Project where id= :projectId");
//		theQuery.setParameter("projectId", theId);
//		theQuery.executeUpdate();
//
//	}

	

}



