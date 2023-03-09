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
@Table(name="em_report", schema = "lira" )
//@NamedQueries({
//	@NamedQuery(name=PyeReport.QUERY_FIND_REPORT,query="SELECT u FROM pye_report u WHERE u.report_id = :report_id")
//})
public class EMReport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="report_id")
	private int report_id;
	
	public int getExperiment_id() {
		return experiment_id;
	}

	public void setExperiment_id(int experiment_id) {
		this.experiment_id = experiment_id;
	}

	@Column(name="experiment_id")
	private int experiment_id;
	
	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int id) {
		this.report_id = id;
	}
	
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
	
	
	@Column(name="internal_std")
	private String internal_std;

	public String getInternal_std() {
		return internal_std;
	}

	public void setInternal_std(String internal_std) {
		this.internal_std = internal_std;
	}
	
	@Column(name="aquisition_id")
	private String aquisition_id;
	public String getAquisition_id() {
		return aquisition_id;
	}

	public void setAquisition_id(String aquisition_id) {
		this.aquisition_id = aquisition_id;
	}
	
	
	
	@Column(name="arearatio_comment")
	private String arearatio_comment;
	
	public String getArearatio_comment() {
		return arearatio_comment;
	}

	public void setArearatio_comment(String arearatio_comment) {
		this.arearatio_comment = arearatio_comment;
	}
	
	
	
	@Column(name="qccomment")
	private String qccomment;
	
	public String getQccomment() {
		return qccomment;
	}

	public void setQccomment(String qccomment) {
		this.qccomment = qccomment;
	}
	
	@Column(name="arearatio_by")
	private String arearatio_by;
	
	public String getArearatio_by() {
		return arearatio_by;
	}

	public void setArearatio_by(String arearatio_by) {
		this.arearatio_by = arearatio_by;
	}
	
	
	@Column(name="qcreview_by")
	private String qcreview_by;
	
	public String getQcreview_by() {
		return qcreview_by;
	}

	public void setQcreview_by(String qcreview_by) {
		this.qcreview_by = qcreview_by;
	}
	
	
	@Column(name="noof_samples")
	private int noof_samples;
	
	public int getNoof_samples() {
		return noof_samples;
	}

	public void setNoof_samples(int noof_samples) {
		this.noof_samples = noof_samples;
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
	
	public EMReport() {
		
	}

	public EMReport(int report_id, int experiment_id, String report_type, int proj_id, String analyte,
			String internal_std, String aquisition_id, String arearatio_comment, String qccomment, String arearatio_by,
			String qcreview_by, int noof_samples, int modified_by, String modified_date) {
		super();
		this.report_id = report_id;
		this.experiment_id = experiment_id;
		this.report_type = report_type;
		this.proj_id = proj_id;
		this.analyte = analyte;
		this.internal_std = internal_std;
		this.aquisition_id = aquisition_id;
		this.arearatio_comment = arearatio_comment;
		this.qccomment = qccomment;
		this.arearatio_by = arearatio_by;
		this.qcreview_by = qcreview_by;
		this.noof_samples = noof_samples;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	@Override
	public String toString() {
		return "EMReport [report_id=" + report_id + ", experiment_id=" + experiment_id + ", report_type=" + report_type
				+ ", proj_id=" + proj_id + ", analyte=" + analyte + ", internal_std=" + internal_std
				+ ", aquisition_id=" + aquisition_id + ", arearatio_comment=" + arearatio_comment + ", qccomment="
				+ qccomment + ", arearatio_by=" + arearatio_by + ", qcreview_by=" + qcreview_by + ", noof_samples="
				+ noof_samples + ", modified_by=" + modified_by + ", modified_date=" + modified_date + "]";
	}
	

	

	

}
