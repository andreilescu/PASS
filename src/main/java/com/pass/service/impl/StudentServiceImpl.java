package com.pass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pass.model.StudentDO;
import com.pass.repository.StudentRepository;
import com.pass.service.api.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<StudentDO> getAll() {
		return (List<StudentDO>) studentRepository.findAll();
	}

	@Override
	public StudentDO findStudent(Integer id) {
		return studentRepository.findByRegistrationNumber(id);
	}

}
