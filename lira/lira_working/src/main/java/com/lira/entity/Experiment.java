package com.lira.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="experiment", schema = "lira" )
//@NamedQueries({
//	@NamedQuery(name=Project.QUERY_FIND_PROJECT,query="SELECT u FROM Project u WHERE u.projectName = :projectName")
//})
public class Experiment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="experiment_id")
	private int experiment_id;
	
	
	public int getExperiment_id() {
		return experiment_id;
	}

	public void setExperiment_id(int experiment_id) {
		this.experiment_id = experiment_id;
	}

	public int getProj_id() {
		return proj_id;
	}

	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}

	public String getExperiment_type() {
		return experiment_type;
	}

	public void setExperiment_type(String experiment_type) {
		this.experiment_type = experiment_type;
	}

	public String getProj_code() {
		return proj_code;
	}

	public void setProj_code(String proj_code) {
		this.proj_code = proj_code;
	}

	public String getRawdata_file() {
		return rawdata_file;
	}

	public void setRawdata_file(String rawdata_file) {
		this.rawdata_file = rawdata_file;
	}

	@Column(name="proj_id")
	private int proj_id;
	
	@Column(name="experiment_type")
	private String experiment_type;
	
	@Column(name="proj_code")
	private String proj_code;
	
	@Column(name="rawdata_file")
	private String rawdata_file;


	public Experiment(int experiment_id, int proj_id, String experiment_type, String proj_code, String rawdata_file) {
		super();
		this.experiment_id = experiment_id;
		this.proj_id = proj_id;
		this.experiment_type = experiment_type;
		this.proj_code = proj_code;
		this.rawdata_file = rawdata_file;
	}
	
	
	public Experiment()
	{
	}

	@Override
	public String toString() {
		return "Experiment [experiment_id=" + experiment_id + ", proj_id=" + proj_id + ", experiment_type="
				+ experiment_type + ", proj_code=" + proj_code + ", rawdata_file=" + rawdata_file + "]";
	}
	

}
