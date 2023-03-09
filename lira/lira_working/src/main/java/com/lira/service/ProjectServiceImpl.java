package com.lira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lira.dao.ProjectDAO;
import com.lira.entity.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	private ProjectDAO projectDAO;

	@Autowired	
	public ProjectServiceImpl(ProjectDAO projectDAO) {
		this.projectDAO=projectDAO;
	}
	
	@Override
	@Transactional
	public List<Project> findAll() {
		System.out.println("in employeeServiceImpl findAll method");
		return projectDAO.findAll();
		
	}

	@Override
	@Transactional
	public Project findById(int theId) {
		
		return projectDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Project theProject) {
		projectDAO.save(theProject);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		projectDAO.delete(theId);

	}
	
	@Override
	@Transactional
	public List<Project> findByStatus(String theStatus) {
		return projectDAO.findByStatus(theStatus);

	}

}
