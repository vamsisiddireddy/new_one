package com.lira.dao;

import java.util.List;

import com.lira.entity.Group;


public interface GroupDAO {
	public List<Group> findAllGroup();
	
	public Group findByGroupId(String theId);
	
	public void saveGroup(Group theGroup);
	
	public void deleteGroup(String theId);
}
