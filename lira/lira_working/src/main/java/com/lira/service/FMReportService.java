package com.lira.service;


import java.util.List;


import com.lira.entity.FMReport;

public interface FMReportService {
	
	public List<FMReport> findAll();
	
	public FMReport findById(int theId);
	
	public void save(FMReport theFMReport);
	
	public void deleteById(int theId);
	
	

}
