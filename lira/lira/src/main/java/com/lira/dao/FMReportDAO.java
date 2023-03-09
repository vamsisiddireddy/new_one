package com.lira.dao;

import java.util.List;

import com.lira.entity.FMReport;

public interface FMReportDAO {
	
	public List<FMReport> findAll();
	
	public FMReport findById(int theId);
	
	public void save(FMReport theFMReport);
	
	public void delete(int theId);

}
