package com.lira.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectReportDetails {
	
	@Id
	@Column(name="proj_id")
	private int projectId;
	
	@Column(name="slope")
	private int slope;
	
	@Column(name="acquisition_id")
	private String acquisitionId;
	
	@Column(name="stds")
	private int stds;
	
	@Column(name="qcs")
	private String qcs;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="created_by")
	private int createdBy;
}
