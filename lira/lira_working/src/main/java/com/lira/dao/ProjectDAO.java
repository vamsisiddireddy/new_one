package com.lira.dao;

import java.util.List;

import com.lira.entity.Project;

public interface ProjectDAO {
	
	public List<Project> findAll();
	
	public Project findById(int theId);
	
	public void save(Project theProject);
	
	public void delete(int theId);
	
	public List<Project> findByStatus(String theStatus);

}
