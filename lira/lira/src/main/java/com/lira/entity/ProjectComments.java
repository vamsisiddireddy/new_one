package com.lira.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectComments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="proj_comments_id")
	private int proj_comments_id;
	
	
	@Column(name="proj_id")
	private int proj_id;
	
	public int getExperiment_id() {
		return experiment_id;
	}

	public void setExperiment_id(int experiment_id) {
		this.experiment_id = experiment_id;
	}

	@Column(name="experiment_id")
	private int experiment_id;
	
	@Column(name="project_comments")
	private String projectComments;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="created_by")
	private int createdBy;

	public int getProj_comments_id() {
		return proj_comments_id;
	}

	public void setProj_comments_id(int proj_comments_id) {
		this.proj_comments_id = proj_comments_id;
	}

	
	public int getProj_id() {
		return proj_id;
	}

	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}

	public String getProjectComments() {
		return projectComments;
	}

	public void setProjectComments(String projectComments) {
		this.projectComments = projectComments;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public ProjectComments() {
		
	}

	public ProjectComments(int proj_comments_id, int proj_id, int experiment_id, String projectComments,
			String createdDate, int createdBy) {
		super();
		this.proj_comments_id = proj_comments_id;
		this.proj_id = proj_id;
		this.experiment_id = experiment_id;
		this.projectComments = projectComments;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "ProjectComments [proj_comments_id=" + proj_comments_id + ", proj_id=" + proj_id + ", experiment_id="
				+ experiment_id + ", projectComments=" + projectComments + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + "]";
	}
	
	
	

}
