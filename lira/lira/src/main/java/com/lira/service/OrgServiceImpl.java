package com.lira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lira.dao.EmployeeDAO;
import com.lira.dao.OrgDAO;
import com.lira.entity.Organization;

@Service
public class OrgServiceImpl implements OrgService {

	private OrgDAO orgDAO;
	

	public OrgServiceImpl() {
		
	}
	
	@Autowired	
	public OrgServiceImpl(OrgDAO orgDAO) {
		this.orgDAO=orgDAO;
	}
	
	@Override
	@Transactional
	public List<Organization> findAllOrg() {
		return orgDAO.findAllOrg();
		
	}

	@Override
	@Transactional
	public Organization findByOrgId(String theOrgId) {
		
		return orgDAO.findByOrgId(theOrgId);
	}

	@Override
	@Transactional
	public void saveOrg(Organization theOrg) {
		orgDAO.saveOrg(theOrg);
	}

	@Override
	@Transactional
	public void deleteByOrgId(String theOrgId) {
		orgDAO.deleteOrg(theOrgId);

	}

}
