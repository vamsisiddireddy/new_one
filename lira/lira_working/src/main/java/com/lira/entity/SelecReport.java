package com.lira.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="selec_report", schema = "lira" )
//@NamedQueries({
//	@NamedQuery(name=PyeReport.QUERY_FIND_REPORT,query="SELECT u FROM pye_report u WHERE u.report_id = :report_id")
//})
public class SelecReport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="report_id")
	private int report_id;
	
	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int id) {
		this.report_id = id;
	}
	
	public int getExperiment_id() {
		return experiment_id;
	}

	public void setExperiment_id(int experiment_id) {
		this.experiment_id = experiment_id;
	}

	@Column(name="experiment_id")
	private int experiment_id;
	
	
	@Column(name="report_type")
	private String report_type;
	
	public String getReport_type() {
		return report_type;
	}

	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}
	
	@Column(name="proj_id")
	private int proj_id;
	
	public int getProj_id() {
		return proj_id;
	}

	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}
	
	@Column(name="analyte")
	private String analyte;
	
	public String getAnalyte() {
		return analyte;
	}

	public void setAnalyte(String analyte) {
		this.analyte = analyte;
	}
	
	
	@Column(name="aquisition_id")
	private String aquisition_id;
	public String getAquisition_id() {
		return aquisition_id;
	}

	public void setAquisition_id(String aquisition_id) {
		this.aquisition_id = aquisition_id;
	}
	@Column(name="internal_std")
	private String internal_std;

	public String getInternal_std() {
		return internal_std;
	}

	public void setInternal_std(String internal_std) {
		this.internal_std = internal_std;
	}
	
	
	@Column(name="comment")
	private String comment;
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	@Column(name="review_by")
	private String review_by;
	
	public String getReview_by() {
		return review_by;
	}

	public void setReview_by(String review_by) {
		this.review_by = review_by;
	}
	
	
	
	@Column(name="modified_by")
	private int modified_by;
	
	public int getModified_by() {
		return modified_by;
	}

	public void setModified_by(int modified_by) {
		this.modified_by = modified_by;
	}
	
	@Column(name="modified_date")
	private String modified_date;
	
	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}
	
	public SelecReport() {
		
	}

	public SelecReport(int report_id, int experiment_id, String report_type, int proj_id, String analyte,
			String aquisition_id, String internal_std, String comment, String review_by, int modified_by,
			String modified_date) {
		super();
		this.report_id = report_id;
		this.experiment_id = experiment_id;
		this.report_type = report_type;
		this.proj_id = proj_id;
		this.analyte = analyte;
		this.aquisition_id = aquisition_id;
		this.internal_std = internal_std;
		this.comment = comment;
		this.review_by = review_by;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	@Override
	public String toString() {
		return "SelecReport [report_id=" + report_id + ", experiment_id=" + experiment_id + ", report_type="
				+ report_type + ", proj_id=" + proj_id + ", analyte=" + analyte + ", aquisition_id=" + aquisition_id
				+ ", internal_std=" + internal_std + ", comment=" + comment + ", review_by=" + review_by
				+ ", modified_by=" + modified_by + ", modified_date=" + modified_date + "]";
	}
	

	

	

}
