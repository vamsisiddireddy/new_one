package com.lira.service;

import java.util.List;

import com.lira.entity.Experiment;

public interface ExperimentService {
	
	public List<Experiment> findAll();
	
	public Experiment findById(int theId);
	
	public void save(Experiment theExperiment);
	
	public void deleteById(int theId);
	
	

}
