package com.lira.dao;

import java.util.List;

import com.lira.entity.Experiment;

public interface ExperimentDAO {
	
	public List<Experiment> findAll();
	
	public Experiment findById(int theId);
	
	public void save(Experiment theExperiment);
	
	public void delete(int theId);
	
	

}
