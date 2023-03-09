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
@Table(name="rec_report", schema = "lira" )
//@NamedQueries({
//	@NamedQuery(name=PyeReport.QUERY_FIND_REPORT,query="SELECT u FROM pye_report u WHERE u.report_id = :report_id")
//})
public class RecReport {
	
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
	
	
	@Column(name="ara_comment")
	private String ara_comment;
	
	public String getAra_comment() {
		return ara_comment;
	}

	public void setAra_comment(String ara_comment) {
		this.ara_comment = ara_comment;
	}
	
	
	
	@Column(name="aris_comment")
	private String aris_comment;
	
	public String getAris_comment() {
		return aris_comment;
	}

	public void setAris_comment(String aris_comment) {
		this.aris_comment = aris_comment;
	}
	
	@Column(name="rra_comment")
	private String rra_comment;
	
	public String getRra_comment() {
		return rra_comment;
	}

	public void setRra_comment(String rra_comment) {
		this.rra_comment = rra_comment;
	}
	
	@Column(name="rris_comment")
	private String rris_comment;
	
	public String getRris_comment() {
		return rris_comment;
	}

	public void setRris_comment(String rris_comment) {
		this.rris_comment = rris_comment;
	}
	
	@Column(name="arareview_by")
	private String arareview_by;
	
	public String getArareview_by() {
		return arareview_by;
	}

	public void setArareview_by(String arareview_by) {
		this.arareview_by = arareview_by;
	}
	
	
	@Column(name="arisreview_by")
	private String arisreview_by;
	
	public String getArisreview_by() {
		return arisreview_by;
	}

	public void setArisreview_by(String arisreview_by) {
		this.arisreview_by = arisreview_by;
	}
	
	@Column(name="rrareview_by")
	private String rrareview_by;
	
	public String getRrareview_by() {
		return rrareview_by;
	}

	public void setRrareview_by(String rrareview_by) {
		this.rrareview_by = rrareview_by;
	}
	
	@Column(name="rrisreview_by")
	private String rrisreview_by;
	
	public String getRrisreview_by() {
		return rrisreview_by;
	}

	public void setRrisreview_by(String rrisreview_by) {
		this.rrisreview_by = rrisreview_by;
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
	
	public RecReport() {
		
	}

	public RecReport(int report_id, int experiment_id, String report_type, int proj_id, String analyte,
			String aquisition_id, String ara_comment, String aris_comment, String rra_comment, String rris_comment,
			String arareview_by, String arisreview_by, String rrareview_by, String rrisreview_by, int modified_by,
			String modified_date) {
		super();
		this.report_id = report_id;
		this.experiment_id = experiment_id;
		this.report_type = report_type;
		this.proj_id = proj_id;
		this.analyte = analyte;
		this.aquisition_id = aquisition_id;
		this.ara_comment = ara_comment;
		this.aris_comment = aris_comment;
		this.rra_comment = rra_comment;
		this.rris_comment = rris_comment;
		this.arareview_by = arareview_by;
		this.arisreview_by = arisreview_by;
		this.rrareview_by = rrareview_by;
		this.rrisreview_by = rrisreview_by;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	@Override
	public String toString() {
		return "RecReport [report_id=" + report_id + ", experiment_id=" + experiment_id + ", report_type=" + report_type
				+ ", proj_id=" + proj_id + ", analyte=" + analyte + ", aquisition_id=" + aquisition_id
				+ ", ara_comment=" + ara_comment + ", aris_comment=" + aris_comment + ", rra_comment=" + rra_comment
				+ ", rris_comment=" + rris_comment + ", arareview_by=" + arareview_by + ", arisreview_by="
				+ arisreview_by + ", rrareview_by=" + rrareview_by + ", rrisreview_by=" + rrisreview_by
				+ ", modified_by=" + modified_by + ", modified_date=" + modified_date + "]";
	}
	

	
	

}
