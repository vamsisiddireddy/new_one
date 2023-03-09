package com.lira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lira.dao.ProjectCommentsDAO;
import com.lira.entity.ProjectComments;

@Service
public class ProjectCommentsServiceImpl implements ProjectCommentsService {

	private ProjectCommentsDAO projectCommentsDAO;

	@Autowired	
	public ProjectCommentsServiceImpl(ProjectCommentsDAO projectCommentsDAO) {
		this.projectCommentsDAO=projectCommentsDAO;
	}
	
	@Override
	@Transactional
	public List<ProjectComments> findAll() {
		System.out.println("in projectCommentsServiceImpl findAll method");
		return projectCommentsDAO.findAll();
		
	}

	@Override
	@Transactional
	public List<ProjectComments> findByProjId(int theId) {
		
		return projectCommentsDAO.findByProjId(theId);
	}

	@Override
	@Transactional
	public void save(ProjectComments theProjectComments) {
		projectCommentsDAO.save(theProjectComments);
	}

//	@Override
//	@Transactional
//	public void deleteById(int theId) {
//		projectCommentsDAO.delete(theId);
//
//	}

}
