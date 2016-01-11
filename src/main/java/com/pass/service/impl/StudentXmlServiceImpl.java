package com.pass.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.pass.XmlConverter;
import com.pass.model.StudentDO;
import com.pass.service.api.StudentXmlService;

@Profile("xml-database")
@Service
public class StudentXmlServiceImpl implements StudentXmlService {
	
	@Autowired
	private XmlConverter xmlConverter;
	
	@Override
	public List<StudentDO> getStudents() throws IOException {
		List<StudentDO> xmlStudent = (List<StudentDO>) xmlConverter.getStudents();
		
		return xmlStudent;
	}
	
}
