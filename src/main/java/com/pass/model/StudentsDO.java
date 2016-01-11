package com.pass.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "students")
public class StudentsDO {

	@XmlElement(name = "student")
    private List<StudentDO> students = null;

	public List<StudentDO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDO> students) {
		this.students = students;
	}
	
}
