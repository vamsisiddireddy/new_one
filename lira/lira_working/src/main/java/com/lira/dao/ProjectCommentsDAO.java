package com.lira.dao;

import java.util.List;

import com.lira.entity.ProjectComments;

public interface ProjectCommentsDAO {
	
	public List<ProjectComments> findAll();
	
	public List<ProjectComments> findById(int theId);
	
	public void save(ProjectComments theProjectComments);
	
	public List<ProjectComments> findByProjId(int theProjId) ;
	//public void delete(int theId);

}