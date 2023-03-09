package com.lira.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="organization")
public class Organization {
	
	@Id
	@Column(name="id")
	private String orgId;
	
	@Column(name="name")
	private String orgName;
	
	@Column(name="description")
	private String description;

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
		return "Organization [id=" + orgId + ", orgName=" + orgName + ", description=" + description + "]";
	}

}
