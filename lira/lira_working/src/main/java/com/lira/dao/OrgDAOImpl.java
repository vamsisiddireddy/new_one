package com.lira.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lira.entity.Employee;
import com.lira.entity.Organization;;
@Service
public class OrgDAOImpl implements OrgDAO{

	private EntityManager entityManager;
	
	@Autowired
	public OrgDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	public List<Organization> findAllOrg() {

		System.out.println("in orgDAOImpl findAllOrg");
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<Organization> theQuery = currentSession.createQuery(" from Organization", Organization.class);
		List<Organization> orgs=theQuery.getResultList();
		System.out.println("in OrgDAOImpl findAll" +orgs.toString() );
		
		
		return orgs;
	}

	@Override
	public Organization findByOrgId(String theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Organization theOrg = currentSession.get(Organization.class, theId);
				
		return theOrg;
	}

	@Override
	public void saveOrg(Organization theOrg) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theOrg);
		
	}

	@Override
	public void deleteOrg(String theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery(" delete from Organization where id= :orgId");
		theQuery.setParameter("orgId", theId);
		theQuery.executeUpdate();
		
	}
	
}
