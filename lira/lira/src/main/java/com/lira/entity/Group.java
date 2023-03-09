package com.lira.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="group")
public class Group {
	
	@Id
	@Column(name="id")
	private String groupId;
	
	@Column(name="group_name")
	private String groupName;
	
	@Column(name="org_id")
	private String orgId;
	
	@Column(name="org_name")
	private String orgName;
	
	@Column(name="description")
	private String description;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String id) {
		this.groupId = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String deptName) {
		this.groupName = deptName;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "group [id=" + groupId + ", groupName=" + groupName + ", orgId=" + orgId + ", orgName=" + orgName
				+ ", description=" + description + "]";
	}

}
