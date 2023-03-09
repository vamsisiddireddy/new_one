package com.lira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lira.dao.GroupDAO;
import com.lira.dao.OrgDAO;
import com.lira.entity.Group;

@Service
public class GroupServiceImpl implements GroupService {

private GroupDAO groupDAO;
	
	
	public GroupServiceImpl() {
		
	}
	
	@Autowired	
	public GroupServiceImpl(GroupDAO groupDAO) {
		this.groupDAO=groupDAO;
	}
	
	@Override
	@Transactional
	public List<Group> findAllGroup() {
		return groupDAO.findAllGroup();
		
	}

	@Override
	@Transactional
	public Group findByGroupId(String theId) {
		
		return groupDAO.findByGroupId(theId);
	}

	@Override
	@Transactional
	public void saveGroup(Group theOrg) {
		groupDAO.saveGroup(theOrg);
	}

	@Override
	@Transactional
	public void deleteByGroupId(String theId) {
		groupDAO.deleteGroup(theId);

	}

}
