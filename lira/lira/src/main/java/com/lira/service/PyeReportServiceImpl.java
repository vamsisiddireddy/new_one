package com.lira.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lira.dao.PyeReportDAO;

import com.lira.entity.PyeReport;

@Service(value = "pyeReportService")
public class PyeReportServiceImpl implements PyeReportService {

	private PyeReportDAO pyeReportDAO;

	@Autowired	
	public PyeReportServiceImpl(PyeReportDAO pyeReportDAO) {
		this.pyeReportDAO=pyeReportDAO;
	}
	
	@Override
	@Transactional
	public List<PyeReport> findAll() {
		System.out.println("in employeeServiceImpl findAll method");
		return pyeReportDAO.findAll();
		
	}

	@Override
	@Transactional
	public PyeReport findById(int theId) {
		
		return pyeReportDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(PyeReport thePyeReport) {
		pyeReportDAO.save(thePyeReport);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		pyeReportDAO.delete(theId);

	}
	
	

}
