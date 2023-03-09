package com.lira.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lira.dao.RecReportDAO;

import com.lira.entity.RecReport;

@Service(value = "recReportService")
public class RecReportServiceImpl implements RecReportService {

	private RecReportDAO recReportDAO;

	@Autowired	
	public RecReportServiceImpl(RecReportDAO recReportDAO) {
		this.recReportDAO=recReportDAO;
	}
	
	@Override
	@Transactional
	public List<RecReport> findAll() {
		System.out.println("in employeeServiceImpl findAll method");
		return recReportDAO.findAll();
		
	}

	@Override
	@Transactional
	public RecReport findById(int theId) {
		
		return recReportDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(RecReport theRecReport) {
		recReportDAO.save(theRecReport);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		recReportDAO.delete(theId);

	}
	
	

}
