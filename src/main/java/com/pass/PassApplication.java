package com.pass;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pass.model.StudentDO;

@SpringBootApplication
public class PassApplication {

	public static void main(String[] args) {
		
		ApplicationContext passApplicationContext = new ClassPathXmlApplicationContext("passApplicationContext.xml");
		
		XmlConverter xmlConverter = (XmlConverter) passApplicationContext.getBean("XmlConverter");
		try {
			
			List<StudentDO> students = xmlConverter.getStudents();
			System.out.println(students);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SpringApplication.run(PassApplication.class, args);
	}
}
