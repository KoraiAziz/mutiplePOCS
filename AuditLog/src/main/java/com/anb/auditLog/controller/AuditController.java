package com.anb.auditLog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anb.auditLog.entity.Student;
import com.anb.auditLog.service.StudentService;

@RestController
@RequestMapping("audit")
public class AuditController {
	
	 private static final Logger logger =LoggerFactory.getLogger(AuditController.class);
	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping("/save")
	public void saveRecord(@RequestBody Student student) {
		
		logger.info("Request : {}",student.toString());
		studentService.saveReceord(student);
		
	}

}
