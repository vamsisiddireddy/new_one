package com.lira.service;


import java.util.List;


import com.lira.entity.RecReport;

public interface RecReportService {
	
	public List<RecReport> findAll();
	
	public RecReport findById(int theId);
	
	public void save(RecReport theEMReport);
	
	public void deleteById(int theId);
	
	

}
