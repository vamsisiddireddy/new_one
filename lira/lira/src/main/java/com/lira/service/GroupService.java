package com.lira.service;

import java.util.List;

import com.lira.entity.Group;


public interface GroupService {
	
	public List<Group> findAllGroup();
	
	public Group findByGroupId(String theId);
	
	public void saveGroup(Group theGroup);
	
	public void deleteByGroupId(String theId);
	
}
