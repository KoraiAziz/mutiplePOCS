package com.anb.auditLog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anb.auditLog.entity.Student;
import com.anb.auditLog.repo.StudentRepo;


@Service
public class StudentService {
	
	 private static final Logger logger =LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	StudentRepo studentRepo;
	
	
	public void saveReceord(Student request) {
		
		logger.info("Before Save");
		Student student= studentRepo.save(request);
		if(student != null) {
			logger.info("Record Saved Successfully");
			logger.info("Saved Record {}",student.toString());
		}
		else {
			logger.info("Failed to save record");
		}
		logger.info("After Save");
		
		
	}
	

}
