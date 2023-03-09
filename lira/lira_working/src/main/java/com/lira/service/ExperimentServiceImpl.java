package com.lira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lira.dao.ExperimentDAO;
import com.lira.entity.Experiment;

@Service
public class ExperimentServiceImpl implements ExperimentService {

	private ExperimentDAO experimentDAO;

	@Autowired	
	public ExperimentServiceImpl(ExperimentDAO experimentDAO) {
		this.experimentDAO=experimentDAO;
	}
	
	@Override
	@Transactional
	public List<Experiment> findAll() {
		System.out.println("in employeeServiceImpl findAll method");
		return experimentDAO.findAll();
		
	}

	@Override
	@Transactional
	public Experiment findById(int theId) {
		
		return experimentDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Experiment theExperiment) {
		experimentDAO.save(theExperiment);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		experimentDAO.delete(theId);

	}
	
	

}
