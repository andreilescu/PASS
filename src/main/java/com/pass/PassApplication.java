package com.pass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PassApplication {

	public static void main(String[] args) {
		
//		ApplicationContext passApplicationContext = new ClassPathXmlApplicationContext("passApplicationContext.xml");
//		
//		XmlConverter xmlConverter = (XmlConverter) passApplicationContext.getBean("XmlConverter");
//		try {
//			
//			List<StudentDO> students = xmlConverter.getStudents();
//			System.out.println(students);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		SpringApplication.run(PassApplication.class, args);
	}
}
