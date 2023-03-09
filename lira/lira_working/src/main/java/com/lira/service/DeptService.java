package com.lira.service;

import java.util.List;

import com.lira.entity.Department;

public interface DeptService {

		public List<Department> findAllDept();
		
		public Department findByDeptId(String theId);
		
		public void saveDept(Department theDept);
		
		public void deleteByDeptId(String theId);
		
	}



