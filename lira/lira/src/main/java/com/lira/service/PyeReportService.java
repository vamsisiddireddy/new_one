package com.lira.service;


import java.util.List;


import com.lira.entity.PyeReport;

public interface PyeReportService {
	
	public List<PyeReport> findAll();
	
	public PyeReport findById(int theId);
	
	public void save(PyeReport thePyeReport);
	
	public void deleteById(int theId);
	
	

}
