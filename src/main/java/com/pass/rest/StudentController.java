package com.pass.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pass.model.StudentDO;
import com.pass.service.api.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(
					method = RequestMethod.GET, 
					produces = MediaType.APPLICATION_JSON_VALUE
	)
	public List<StudentDO> getAll() {
		return studentService.getAll();
	}
	
	@RequestMapping(
					value = "{registrationNumber}", 
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE
	)
	public StudentDO findSudent (@PathVariable Integer registrationNumber) {
		return studentService.findStudent(registrationNumber);
	}
	
}
