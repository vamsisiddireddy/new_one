package com.lira.service;

import java.util.List;

import com.lira.entity.Organization;

public interface OrgService {

	public List<Organization> findAllOrg();
	
	public Organization findByOrgId(String theId);
	
	public void saveOrg(Organization theUser);
	
	public void deleteByOrgId(String theId);
	
}





