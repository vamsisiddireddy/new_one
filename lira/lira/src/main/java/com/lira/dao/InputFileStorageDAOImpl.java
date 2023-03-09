package com.lira.dao;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lira.entity.InputFile;

@Service
public class InputFileStorageDAOImpl implements InputFileStorageDAO {

	private EntityManager entityManager;
	
	@Autowired
	public InputFileStorageDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}

	

	@Override
	public InputFile findByDocId(int theId) {
		
		Session currentSession =  entityManager.unwrap(Session.class);
				
		InputFile theInputFile = currentSession.get(InputFile.class, theId);
				
		return theInputFile;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<InputFile> findByProjId(int theId) {
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<InputFile> theQuery = currentSession.createQuery(" from InputFile", InputFile.class);
		List<InputFile> projFiles=theQuery.getResultList();
		return projFiles;
	}

	@Override
	public void deleteByDocId(int theId) {
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery(" delete from InputFile where id= :theId");
		theQuery.setParameter("groupId", theId);
		theQuery.executeUpdate();
		
	}

	@Override
	public void storeFile(InputFile inputFile) {
		Session currentSession =  entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(inputFile);
	}



	@Override
	public List<InputFile> findByAll(int theId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
