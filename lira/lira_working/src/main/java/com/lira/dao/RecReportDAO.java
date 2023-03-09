package com.lira.dao;

import java.util.List;

import com.lira.entity.RecReport;

public interface RecReportDAO {
	
	public List<RecReport> findAll();
	
	public RecReport findById(int theId);
	
	public void save(RecReport theRecReport);
	
	public void delete(int theId);

}
