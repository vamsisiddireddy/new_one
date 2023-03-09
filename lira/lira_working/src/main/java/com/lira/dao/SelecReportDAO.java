package com.lira.dao;

import java.util.List;

import com.lira.entity.SelecReport;

public interface SelecReportDAO {
	
	public List<SelecReport> findAll();
	
	public SelecReport findById(int theId);
	
	public void save(SelecReport theSelecReport);
	
	public void delete(int theId);

}
