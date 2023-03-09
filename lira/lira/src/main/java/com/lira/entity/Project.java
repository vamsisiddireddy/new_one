package com.lira.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project", schema = "lira" )
//@NamedQueries({
//	@NamedQuery(name=Project.QUERY_FIND_PROJECT,query="SELECT u FROM Project u WHERE u.projectName = :projectName")
//})
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="proj_id")
	private int proj_id;
	
	public Project()
	{
		
	}
	
	public Project(int proj_id, String proj_name, String description, int primary_grp_leader_id,
			int secondary_grp_leader_id, int primary_coordinator_id, int secondary_coordinator_id, int primary_qa_id,
			int secondary_qa_id, int primary_qc_id, int secondary_qc_id, int primary_internal_monitor_id,
			int secondary_internal_monitor_id, int primary_reg_manager_id, int secondary_reg_manager_id,
			int primary_hod_bio_id, int secondary_hod_bio_id, int primary_hod_pb_id, int secondary_hod_pb_id,
			int primary_san_responsibility_id, int secondary_san_responsibility_id, String createdDate, int createdBy,
			String modifiedDate, int modifiedBy, String proj_code, String proj_template, String proj_type,
			String status,String experiments) {
		super();
		this.proj_id = proj_id;
		this.proj_name = proj_name;
		this.description = description;
		this.primary_grp_leader_id = primary_grp_leader_id;
		this.secondary_grp_leader_id = secondary_grp_leader_id;
		this.primary_coordinator_id = primary_coordinator_id;
		this.secondary_coordinator_id = secondary_coordinator_id;
		this.primary_qa_id = primary_qa_id;
		this.secondary_qa_id = secondary_qa_id;
		this.primary_qc_id = primary_qc_id;
		this.secondary_qc_id = secondary_qc_id;
		this.primary_internal_monitor_id = primary_internal_monitor_id;
		this.secondary_internal_monitor_id = secondary_internal_monitor_id;
		this.primary_reg_manager_id = primary_reg_manager_id;
		this.secondary_reg_manager_id = secondary_reg_manager_id;
		this.primary_hod_bio_id = primary_hod_bio_id;
		this.secondary_hod_bio_id = secondary_hod_bio_id;
		this.primary_hod_pb_id = primary_hod_pb_id;
		this.secondary_hod_pb_id = secondary_hod_pb_id;
		this.primary_san_responsibility_id = primary_san_responsibility_id;
		this.secondary_san_responsibility_id = secondary_san_responsibility_id;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.proj_code = proj_code;
		this.proj_template = proj_template;
		this.proj_type = proj_type;
		this.status = status;
		this.experiments = experiments;
	}

	@Override
	public String toString() {
		return "Project [proj_id=" + proj_id + ", proj_name=" + proj_name + ", description=" + description
				+ ", primary_grp_leader_id=" + primary_grp_leader_id + ", secondary_grp_leader_id="
				+ secondary_grp_leader_id + ", primary_coordinator_id=" + primary_coordinator_id
				+ ", secondary_coordinator_id=" + secondary_coordinator_id + ", primary_qa_id=" + primary_qa_id
				+ ", secondary_qa_id=" + secondary_qa_id + ", primary_qc_id=" + primary_qc_id + ", secondary_qc_id="
				+ secondary_qc_id + ", primary_internal_monitor_id=" + primary_internal_monitor_id
				+ ", secondary_internal_monitor_id=" + secondary_internal_monitor_id + ", primary_reg_manager_id="
				+ primary_reg_manager_id + ", secondary_reg_manager_id=" + secondary_reg_manager_id
				+ ", primary_hod_bio_id=" + primary_hod_bio_id + ", secondary_hod_bio_id=" + secondary_hod_bio_id
				+ ", primary_hod_pb_id=" + primary_hod_pb_id + ", secondary_hod_pb_id=" + secondary_hod_pb_id
				+ ", primary_san_responsibility_id=" + primary_san_responsibility_id + ", secondary_san_responsibility_id="
				+ secondary_san_responsibility_id + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", modifiedDate=" + modifiedDate + ", modifiedBy=" + modifiedBy + ", proj_code=" + proj_code
				+ ", proj_template=" + proj_template + ", proj_type=" + proj_type + ", status=" + status +", experiments = "+experiments+ "]";
	}

	public int getProj_id() {
		return proj_id;
	}

	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}

	public String getProj_name() {
		return proj_name;
	}

	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrimary_grp_leader_id() {
		return primary_grp_leader_id;
	}

	public void setPrimary_grp_leader_id(int primary_grp_leader_id) {
		this.primary_grp_leader_id = primary_grp_leader_id;
	}

	public int getSecondary_grp_leader_id() {
		return secondary_grp_leader_id;
	}

	public void setSecondary_grp_leader_id(int secondary_grp_leader_id) {
		this.secondary_grp_leader_id = secondary_grp_leader_id;
	}

	public int getPrimary_coordinator_id() {
		return primary_coordinator_id;
	}

	public void setPrimary_coordinator_id(int primary_coordinator_id) {
		this.primary_coordinator_id = primary_coordinator_id;
	}

	public int getSecondary_coordinator_id() {
		return secondary_coordinator_id;
	}

	public void setSecondary_coordinator_id(int secondary_coordinator_id) {
		this.secondary_coordinator_id = secondary_coordinator_id;
	}

	public int getPrimary_qa_id() {
		return primary_qa_id;
	}

	public void setPrimary_qa_id(int primary_qa_id) {
		this.primary_qa_id = primary_qa_id;
	}

	public int getSecondary_qa_id() {
		return secondary_qa_id;
	}

	public void setSecondary_qa_id(int secondary_qa_id) {
		this.secondary_qa_id = secondary_qa_id;
	}

	public int getPrimary_qc_id() {
		return primary_qc_id;
	}

	public void setPrimary_qc_id(int primary_qc_id) {
		this.primary_qc_id = primary_qc_id;
	}

	public int getSecondary_qc_id() {
		return secondary_qc_id;
	}

	public void setSecondary_qc_id(int secondary_qc_id) {
		this.secondary_qc_id = secondary_qc_id;
	}

	public int getPrimary_internal_monitor_id() {
		return primary_internal_monitor_id;
	}

	public void setPrimary_internal_monitor_id(int primary_internal_monitor_id) {
		this.primary_internal_monitor_id = primary_internal_monitor_id;
	}

	public int getSecondary_internal_monitor_id() {
		return secondary_internal_monitor_id;
	}

	public void setSecondary_internal_monitor_id(int secondary_internal_monitor_id) {
		this.secondary_internal_monitor_id = secondary_internal_monitor_id;
	}

	public int getPrimary_reg_manager_id() {
		return primary_reg_manager_id;
	}

	public void setPrimary_reg_manager_id(int primary_reg_manager_id) {
		this.primary_reg_manager_id = primary_reg_manager_id;
	}

	public int getSecondary_reg_manager_id() {
		return secondary_reg_manager_id;
	}

	public void setSecondary_reg_manager_id(int secondary_reg_manager_id) {
		this.secondary_reg_manager_id = secondary_reg_manager_id;
	}

	public int getPrimary_hod_bio_id() {
		return primary_hod_bio_id;
	}

	public void setPrimary_hod_bio_id(int primary_hod_bio_id) {
		this.primary_hod_bio_id = primary_hod_bio_id;
	}

	public int getSecondary_hod_bio_id() {
		return secondary_hod_bio_id;
	}

	public void setSecondary_hod_bio_id(int secondary_hod_bio_id) {
		this.secondary_hod_bio_id = secondary_hod_bio_id;
	}

	public int getPrimary_hod_pb_id() {
		return primary_hod_pb_id;
	}

	public void setPrimary_hod_pb_id(int primary_hod_pb_id) {
		this.primary_hod_pb_id = primary_hod_pb_id;
	}

	public int getSecondary_hod_pb_id() {
		return secondary_hod_pb_id;
	}

	public void setSecondary_hod_pb_id(int secondary_hod_pb_id) {
		this.secondary_hod_pb_id = secondary_hod_pb_id;
	}

	public int getPrimary_san_responsibility_id() {
		return primary_san_responsibility_id;
	}

	public void setPrimary_san_responsibility_id(int primary_san_responsibility_id) {
		this.primary_san_responsibility_id = primary_san_responsibility_id;
	}

	public int getSecondary_san_responsibility_id() {
		return secondary_san_responsibility_id;
	}

	public void setSecondary_san_responsibility_id(int secondary_san_responsibility_id) {
		this.secondary_san_responsibility_id = secondary_san_responsibility_id;
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

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getProj_code() {
		return proj_code;
	}

	public void setProj_code(String proj_code) {
		this.proj_code = proj_code;
	}

	public String getProj_template() {
		return proj_template;
	}

	public void setProj_template(String proj_template) {
		this.proj_template = proj_template;
	}

	public String getProj_type() {
		return proj_type;
	}

	public void setProj_type(String proj_type) {
		this.proj_type = proj_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="experiments")
	private String experiments;

	public String getExperiments() {
		return experiments;
	}

	public void setExperiments(String experiments) {
		this.experiments = experiments;
	}

	@Column(name="proj_name")
	private String proj_name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="primary_grp_leader_id")
	private int primary_grp_leader_id;
	
	@Column(name="secondary_grp_leader_id")
	private int secondary_grp_leader_id;
	
	@Column(name="primary_coordinator_id")
	private int primary_coordinator_id;
	
	@Column(name="secondary_coordinator_id")
	private int secondary_coordinator_id;
	
	@Column(name="primary_qa_id")
	private int primary_qa_id;
	
	@Column(name="secondary_qa_id")
	private int secondary_qa_id;
	
	
	@Column(name="primary_qc_id")
	private int primary_qc_id;
	

	@Column(name="secondary_qc_id")
	private int secondary_qc_id;
	

	@Column(name="primary_internal_monitor_id")
	private int primary_internal_monitor_id;

	
	@Column(name="secondary_internal_monitor_id")
	private int secondary_internal_monitor_id;

	
	@Column(name="primary_reg_manager_id")
	private int primary_reg_manager_id;
	
	@Column(name="secondary_reg_manager_id")
	private int secondary_reg_manager_id;
	
	@Column(name="primary_hod_bio_id")
	private int primary_hod_bio_id;
	
	@Column(name="secondary_hod_bio_id")
	private int secondary_hod_bio_id;
	
	@Column(name="primary_hod_pb_id")
	private int primary_hod_pb_id;
	
	@Column(name="secondary_hod_pb_id")
	private int secondary_hod_pb_id;
	
	@Column(name="primary_san_responsibility_id")
	private int primary_san_responsibility_id;

	
	@Column(name="secondary_san_responsibility_id")
	private int secondary_san_responsibility_id;

	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="modified_date")
	private String modifiedDate;
	
	@Column(name="modified_by")
	private int modifiedBy;
	
	@Column(name="proj_code")
	private String proj_code;
	
	@Column(name="proj_template")
	private String proj_template;
	
	@Column(name="proj_type")
	private String proj_type;
	
	@Column(name="status")
	private String status;
	
	
	
	
	
	
	
	

	

}
