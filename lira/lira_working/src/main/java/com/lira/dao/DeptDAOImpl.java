package com.lira.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lira.entity.Department;

@Service
public class DeptDAOImpl implements DeptDAO {

private EntityManager entityManager;
	
	@Autowired
	public DeptDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	public List<Department> findAllDept() {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<Department> theQuery = currentSession.createQuery(" from Department", Department.class);
		List<Department> depts=theQuery.getResultList();
		
		return depts;
	}

	@Override
	public Department findByDeptId(String theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Department theDept = currentSession.get(Department.class, theId);
				
		return theDept;
	}

	@Override
	public void saveDept(Department theDept) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theDept);
		
	}

	@Override
	public void deleteDept(String theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery(" delete from Department where id= :deptId");
		theQuery.setParameter("deptId", theId);
		theQuery.executeUpdate();
		
	}

}
