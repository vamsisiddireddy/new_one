package com.lira.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lira.entity.Group;
import com.lira.entity.Organization;

@Service
public class GroupDAOImpl implements GroupDAO {

private EntityManager entityManager;
	
	@Autowired
	public GroupDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	public List<Group> findAllGroup() {
				
		System.out.println("in groupDAOImpl findAllGroup");
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<Group> theQuery = currentSession.createQuery(" from Group", Group.class);
		List<Group> groups=theQuery.getResultList();
		System.out.println("in GroupDAOImpl findAll" +groups.toString() );
		
		
		return groups;
	}

	@Override
	public Group findByGroupId(String theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Group theGroup = currentSession.get(Group.class, theId);
				
		return theGroup;
	}

	@Override
	public void saveGroup(Group theGroup) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theGroup);
		
	}

	@Override
	public void deleteGroup(String theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery(" delete from Group where id= :groupId");
		theQuery.setParameter("groupId", theId);
		theQuery.executeUpdate();
		
	}

}
