package com.lira.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lira.dao.SelecReportDAO;

import com.lira.entity.SelecReport;

@Service(value = "selecReportService")
public class SelecReportServiceImpl implements SelecReportService {

	private SelecReportDAO selecReportDAO;

	@Autowired	
	public SelecReportServiceImpl(SelecReportDAO selecReportDAO) {
		this.selecReportDAO=selecReportDAO;
	}
	
	@Override
	@Transactional
	public List<SelecReport> findAll() {
		System.out.println("in SelecReportServiceImpl findAll method");
		return selecReportDAO.findAll();
		
	}

	@Override
	@Transactional
	public SelecReport findById(int theId) {
		
		return selecReportDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(SelecReport theSelecReport) {
		selecReportDAO.save(theSelecReport);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		selecReportDAO.delete(theId);

	}
	
	

}
