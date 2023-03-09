package com.lira.dao;

import java.util.List;

import com.lira.entity.PyeReport;

public interface PyeReportDAO {
	
	public List<PyeReport> findAll();
	
	public PyeReport findById(int theId);
	
	public void save(PyeReport theEmployee);
	
	public void delete(int theId);

}
