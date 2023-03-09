package com.lira.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "project_documents")
public class InputFile {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Integer documentId;

    @Column(name = "proj_id")
    private int ProjId;
    
    public Integer getExperiment_id() {
		return experiment_id;
	}

	public void setExperiment_id(Integer experiment_id) {
		this.experiment_id = experiment_id;
	}

	@Column(name = "experiment_id")
    private Integer experiment_id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "document_type")
    private String documentType;

//    @Lob
//    @Column(name = "data")
//    private byte[] data;
    
    @Column(name = "upload_dir")
    private String uploadDir;
    
	@Column(name="uploaded_date")
	private String createdDate;
	
	@Column(name="uploaded_by")
	private int createdBy;

	public InputFile() {
		
	}

	

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public int getProjId() {
		return ProjId;
	}

	public void setProjId(int projId) {
		ProjId = projId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

//	public byte[] getData() {
//		return data;
//	}
//
//	public void setData(byte[] data) {
//		this.data = data;
//	}

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
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

	public InputFile(Integer documentId, int projId, Integer experiment_id, String fileName, String documentType,
			String uploadDir, String createdDate, int createdBy) {
		super();
		this.documentId = documentId;
		ProjId = projId;
		this.experiment_id = experiment_id;
		this.fileName = fileName;
		this.documentType = documentType;
		this.uploadDir = uploadDir;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "InputFile [documentId=" + documentId + ", ProjId=" + ProjId + ", experiment_id=" + experiment_id
				+ ", fileName=" + fileName + ", documentType=" + documentType + ", uploadDir=" + uploadDir
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + "]";
	}

	

	
}
