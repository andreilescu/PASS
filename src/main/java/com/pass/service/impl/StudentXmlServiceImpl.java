package com.pass.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.stereotype.Service;

import com.pass.XmlConverter;
import com.pass.model.StudentDO;
import com.pass.service.api.StudentXmlService;


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
