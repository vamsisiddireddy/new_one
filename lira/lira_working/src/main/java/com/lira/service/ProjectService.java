package com.lira.service;

import java.util.List;

import com.lira.entity.Project;

public interface ProjectService {
	
	public List<Project> findAll();
	
	public Project findById(int theId);
	
	public void save(Project theProject);
	
	public void deleteById(int theId);
	
	public List<Project> findByStatus(String status);

}
