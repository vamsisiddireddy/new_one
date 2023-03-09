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
@Table(name="pye_report", schema = "lira" )
//@NamedQueries({
//	@NamedQuery(name=PyeReport.QUERY_FIND_REPORT,query="SELECT u FROM pye_report u WHERE u.report_id = :report_id")
//})
public class PyeReport {
	
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

	public String getNoof_stds() {
		return noof_stds;
	}

	public void setNoof_stds(String noof_stds) {
		this.noof_stds = noof_stds;
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
	
	@Column(name="slope")
	private String slope;
	public String getSlope() {
		return slope;
	}

	public void setSlope(String slope) {
		this.slope = slope;
	}
	
	@Column(name="intercept")
	private String intercept;
	public String getIntercept() {
		return intercept;
	}

	public void setIntercept(String intercept) {
		this.intercept = intercept;
	}
	
	@Column(name="regression")
	private String regression;
	public String getRegression() {
		return regression;
	}

	public void setRegression(String regression) {
		this.regression = regression;
	}
	
	
	@Column(name="std_comment")
	private String std_comment;
	
	public String getStd_comment() {
		return std_comment;
	}

	public void setStd_comment(String std_comment) {
		this.std_comment = std_comment;
	}
	
	
	
	@Column(name="qccomment")
	private String qccomment;
	
	public String getQccomment() {
		return qccomment;
	}

	public void setQccomment(String qccomment) {
		this.qccomment = qccomment;
	}
	
	@Column(name="stdreview_by")
	private String stdreview_by;
	
	public String getStdreview_by() {
		return stdreview_by;
	}

	public void setStdreview_by(String stdreview_by) {
		this.stdreview_by = stdreview_by;
	}
	
	
	@Column(name="qcreview_by")
	private String qcreview_by;
	
	public String getQcreview_by() {
		return qcreview_by;
	}

	public void setQcreview_by(String qcreview_by) {
		this.qcreview_by = qcreview_by;
	}
	
	
	@Column(name="noof_stds")
	private String noof_stds;

	
	
	@Column(name="qcs")
	private String qcs;
	
	public String getQcs() {
		return qcs;
	}

	public void setQcs(String qcs) {
		this.qcs = qcs;
	}
	
	
	@Column(name="n_concentrations")
	private String n_concentrations;
	
	public String getN_concentrations() {
		return n_concentrations;
	}

	public void setN_concentrations(String n_concentrations) {
		this.n_concentrations = n_concentrations;
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
	
	public PyeReport() {
		
	}

	public PyeReport(int report_id, int experiment_id, String report_type, int proj_id, String analyte,
			String internal_std, String aquisition_id, String slope, String intercept, String regression,
			String std_comment, String qccomment, String stdreview_by, String qcreview_by, String noof_stds, String qcs,
			String n_concentrations, int modified_by, String modified_date) {
		super();
		this.report_id = report_id;
		this.experiment_id = experiment_id;
		this.report_type = report_type;
		this.proj_id = proj_id;
		this.analyte = analyte;
		this.internal_std = internal_std;
		this.aquisition_id = aquisition_id;
		this.slope = slope;
		this.intercept = intercept;
		this.regression = regression;
		this.std_comment = std_comment;
		this.qccomment = qccomment;
		this.stdreview_by = stdreview_by;
		this.qcreview_by = qcreview_by;
		this.noof_stds = noof_stds;
		this.qcs = qcs;
		this.n_concentrations = n_concentrations;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	@Override
	public String toString() {
		return "PyeReport [report_id=" + report_id + ", experiment_id=" + experiment_id + ", report_type=" + report_type
				+ ", proj_id=" + proj_id + ", analyte=" + analyte + ", internal_std=" + internal_std
				+ ", aquisition_id=" + aquisition_id + ", slope=" + slope + ", intercept=" + intercept + ", regression="
				+ regression + ", std_comment=" + std_comment + ", qccomment=" + qccomment + ", stdreview_by="
				+ stdreview_by + ", qcreview_by=" + qcreview_by + ", noof_stds=" + noof_stds + ", qcs=" + qcs
				+ ", n_concentrations=" + n_concentrations + ", modified_by=" + modified_by + ", modified_date="
				+ modified_date + "]";
	}
	

	

	

}
