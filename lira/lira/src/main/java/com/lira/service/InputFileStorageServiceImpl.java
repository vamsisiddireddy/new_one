package com.lira.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lira.dao.GroupDAO;
import com.lira.dao.InputFileStorageDAO;
import com.lira.entity.Employee;
import com.lira.entity.InputFile;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class InputFileStorageServiceImpl implements InputFileStorageService {

	@Autowired
	private InputFileStorageDAO inputFileStorageDAO;
	
	public InputFileStorageServiceImpl() {
		
	}
	
	@Autowired	
	public InputFileStorageServiceImpl(InputFileStorageDAO inputFileStorageDAO) {
		this.inputFileStorageDAO=inputFileStorageDAO;
	}

	@Override
	public void storeFile(InputFile inputFile) {
		inputFileStorageDAO.storeFile(inputFile);
		
	}

	@Override
	public InputFile findByDocId(int theId) {
		return inputFileStorageDAO.findByDocId(theId);
	}

	@Override
	public List<InputFile> findByProjId(int theId) {
		return inputFileStorageDAO.findByProjId(theId);
	}

	@Override
	public List<InputFile> findByAll(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByDocId(int theId) {
		inputFileStorageDAO.deleteByDocId(theId);
		
	}
	
	
	
	
	
	
}
