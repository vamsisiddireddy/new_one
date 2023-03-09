package com.lira.dao;

import java.util.List;

import com.lira.entity.Department;

public interface DeptDAO {
	
	public List<Department> findAllDept();
	
	public Department findByDeptId(String theId);
	
	public void saveDept(Department theDept);
	
	public void deleteDept(String theId);

}