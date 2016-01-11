package com.pass.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pass.model.StudentDO;
import com.pass.service.api.StudentXmlService;

@Profile("xml-database")
@RestController
@RequestMapping(value = "/student")
public class StudentXmlController {

	@Autowired
	private StudentXmlService studentXmlService;
	
	@RequestMapping(
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public List<StudentDO> getAll() throws IOException {

		
//		StudentDO studentXml = new StudentDO();
//		studentXml.setId(1);
//		studentXml.setName("XML Student");
//		studentXml.setRegistrationNumber(1740);
//		studentXml.setAverageRate(8.2);
		List<StudentDO> studentXmls = studentXmlService.getStudents();
		
		return studentXmls;
	}
	
}
