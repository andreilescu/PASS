package com.pass.repository;

import org.springframework.data.repository.CrudRepository;

import com.pass.model.StudentDO;

public interface StudentRepository extends CrudRepository<StudentDO, Integer> {

	StudentDO findByRegistrationNumber(Integer rn);
}
