package com.lira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lira.dao.DeptDAO;
import com.lira.dao.EmployeeDAO;
import com.lira.dao.OrgDAO;
import com.lira.entity.Department;
import com.lira.entity.Employee;

@Service
public class DeptServiceImpl implements DeptService{
	private DeptDAO deptDAO;
	

	public DeptServiceImpl() {
		
	}
	
	@Autowired	
	public DeptServiceImpl(DeptDAO deptDAO) {
		this.deptDAO=deptDAO;
	}
	
	@Override
	@Transactional
	public List<Department> findAllDept() {
		return deptDAO.findAllDept();
		
	}

	@Override
	@Transactional
	public Department findByDeptId(String theId) {
		
		return deptDAO.findByDeptId(theId);
	}

	@Override
	@Transactional
	public void saveDept(Department theDept) {
		deptDAO.saveDept(theDept);
	}

	@Override
	@Transactional
	public void deleteByDeptId(String theId) {
		deptDAO.deleteDept(theId);

	}

	
}
