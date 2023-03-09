package com.lira.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lira.dao.FMReportDAO;

import com.lira.entity.FMReport;

@Service(value = "fmReportService")
public class FMReportServiceImpl implements FMReportService {

	private FMReportDAO fmReportDAO;

	@Autowired	
	public FMReportServiceImpl(FMReportDAO fmReportDAO) {
		this.fmReportDAO=fmReportDAO;
	}
	
	@Override
	@Transactional
	public List<FMReport> findAll() {
		System.out.println("in employeeServiceImpl findAll method");
		return fmReportDAO.findAll();
		
	}

	@Override
	@Transactional
	public FMReport findById(int theId) {
		
		return fmReportDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(FMReport theFMReport) {
		fmReportDAO.save(theFMReport);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		fmReportDAO.delete(theId);

	}
	
	

}
