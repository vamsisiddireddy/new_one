package com.lira.dao;

import java.util.List;

import com.lira.entity.EMReport;

public interface EMReportDAO {
	
	public List<EMReport> findAll();
	
	public EMReport findById(int theId);
	
	public void save(EMReport theEMReport);
	
	public void delete(int theId);

}
