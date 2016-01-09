package com.pass.service.api;

import java.util.List;

import com.pass.model.StudentDO;

public interface StudentService {
	
	List<StudentDO> getAll();
	
	StudentDO findStudent(Integer id);
	
}
