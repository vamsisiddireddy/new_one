package com.lira.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lira.dao.EMReportDAO;

import com.lira.entity.EMReport;

@Service(value = "emReportService")
public class EMReportServiceImpl implements EMReportService {

	private EMReportDAO emReportDAO;

	@Autowired	
	public EMReportServiceImpl(EMReportDAO emReportDAO) {
		this.emReportDAO=emReportDAO;
	}
	
	@Override
	@Transactional
	public List<EMReport> findAll() {
		System.out.println("in employeeServiceImpl findAll method");
		return emReportDAO.findAll();
		
	}

	@Override
	@Transactional
	public EMReport findById(int theId) {
		
		return emReportDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(EMReport thePyeReport) {
		emReportDAO.save(thePyeReport);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		emReportDAO.delete(theId);

	}
	
	

}
