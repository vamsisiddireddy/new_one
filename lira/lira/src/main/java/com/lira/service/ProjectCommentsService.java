package com.lira.service;

import java.util.List;

import com.lira.entity.ProjectComments;

public interface ProjectCommentsService {
	
	public List<ProjectComments> findAll();
	
	public List<ProjectComments> findByProjId(int theId);
	
	public void save(ProjectComments theProjectComments);
	
	//public void deleteById(int theId);

}