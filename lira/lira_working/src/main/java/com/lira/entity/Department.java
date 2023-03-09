package com.lira.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	
	@Id
	@Column(name="id")
	private String deptId;
	
	@Column(name="dept_name")
	private String deptName;
	
	@Column(name="org_id")
	private String orgId;
	
	@Column(name="org_name")
	private String orgName;
	
	@Column(name="HOD")
	private int HOD;
	
	@Column(name="parent_dept")
	private String parentDept;
	
	@Column(name="description")
	private String description;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String id) {
		this.deptId = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public int getHOD() {
		return HOD;
	}

	public void setHOD(int hOD) {
		HOD = hOD;
	}

	public String getParentDept() {
		return parentDept;
	}

	public void setParentDept(String parentDept) {
		this.parentDept = parentDept;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Department [id=" + deptId + ", deptName=" + deptName + ", orgId=" + orgId + ", orgName=" + orgName
				+ ", HOD=" + HOD + ", parentDept=" + parentDept + ", description=" + description + "]";
	}

}
