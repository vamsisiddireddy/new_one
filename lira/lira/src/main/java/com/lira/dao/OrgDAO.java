package com.lira.dao;

import java.util.List;

import com.lira.entity.Organization;;

public interface OrgDAO {
	
	public List<Organization> findAllOrg();
	
	public Organization findByOrgId(String theId);
	
	public void saveOrg(Organization theOrg);
	
	public void deleteOrg(String theId);

}

