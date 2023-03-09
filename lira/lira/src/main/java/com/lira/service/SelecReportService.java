package com.lira.service;


import java.util.List;


import com.lira.entity.SelecReport;

public interface SelecReportService {
	
	public List<SelecReport> findAll();
	
	public SelecReport findById(int theId);
	
	public void save(SelecReport theSelecReport);
	
	public void deleteById(int theId);
	
	

}
