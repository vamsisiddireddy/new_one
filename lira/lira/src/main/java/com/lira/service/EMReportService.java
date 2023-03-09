package com.lira.service;


import java.util.List;


import com.lira.entity.EMReport;

public interface EMReportService {
	
	public List<EMReport> findAll();
	
	public EMReport findById(int theId);
	
	public void save(EMReport theEMReport);
	
	public void deleteById(int theId);
	
	

}
