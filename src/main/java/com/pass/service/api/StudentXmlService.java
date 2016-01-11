package com.pass.service.api;

import java.io.IOException;
import java.util.List;

import com.pass.model.StudentDO;

public interface StudentXmlService {
	
	List<StudentDO> getStudents() throws IOException;
}
