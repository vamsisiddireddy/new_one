package com.lira.dao;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.lira.entity.InputFile;

public interface InputFileStorageDAO {

	public void storeFile(InputFile inputFile);
	
	public InputFile findByDocId(int theId);
	
	public List <InputFile> findByProjId(int theId);
	
	public List <InputFile> findByAll(int theId);
	
	public void deleteByDocId(int theId);
}
