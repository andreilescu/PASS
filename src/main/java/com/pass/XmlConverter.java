package com.pass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import com.pass.model.StudentDO;
import com.pass.model.StudentsDO;

public class XmlConverter {
	
	private static final String FILE_NAME = "import.xml";
	@Autowired
	private Marshaller marshaller;
	@Autowired
	private Unmarshaller unmarshaller;
	
	
	public void createStudentXml() throws IOException {
		FileOutputStream os = null;
		StudentsDO generatedList = new StudentsDO();
		generatedList.setStudents(this.generateStudents());
		
		try {
		
			System.out.println("--- Marshaller ---");
			os = new FileOutputStream(FILE_NAME);
			
  			this.marshaller.marshal(generatedList, new StreamResult(os));
			System.out.println("Students: " + generatedList + " saved to info.xml file. ");

		} finally {
			if (os != null) {
				os.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<StudentDO> getStudents() throws IOException {
		createStudentXml();
		
		// Unmarshall the xml file to StudentDO object
		FileInputStream is = null;		
		StudentsDO xmlStudents;
		List<StudentDO> studentDOs = new ArrayList<>();
		
		try {
			System.out.println("-----> Unmarshaller ----->");
			is = new FileInputStream(FILE_NAME);
			
			xmlStudents = (StudentsDO) this.unmarshaller.unmarshal(new StreamSource(is));
			studentDOs = xmlStudents.getStudents();
			System.out.println("Students from XML: " + xmlStudents);
			System.out.println("Students from XML: " + studentDOs);
			
		} finally {
			
			if(is != null) {
				is.close();
			}
		}
		return studentDOs;
	}
	
	private List<StudentDO> generateStudents() {
		
		List<StudentDO> xmlStudents = new ArrayList<>();
		StudentDO xmlStudent1 = new StudentDO();
		StudentDO xmlStudent2 = new StudentDO();
		StudentDO xmlStudent3 = new StudentDO();
		StudentDO xmlStudent4 = new StudentDO();
		StudentDO xmlStudent5 = new StudentDO();
		
		xmlStudent1.setId(1);
		xmlStudent1.setName("John XML");
		xmlStudent1.setAverageRate(8.2);
		xmlStudent1.setRegistrationNumber(7339);
		
		xmlStudent2.setId(2);
		xmlStudent2.setName("Andrew XML");
		xmlStudent2.setAverageRate(9.2);
		xmlStudent2.setRegistrationNumber(7340);
		
		xmlStudent3.setId(3);
		xmlStudent3.setName("Bob XML");
		xmlStudent3.setAverageRate(7.2);
		xmlStudent3.setRegistrationNumber(7341);
		
		xmlStudent4.setId(4);
		xmlStudent4.setName("Sam XML");
		xmlStudent4.setAverageRate(8.2);
		xmlStudent4.setRegistrationNumber(7342);
		
		xmlStudent5.setId(5);
		xmlStudent5.setName("John XML");
		xmlStudent5.setAverageRate(8.7);
		xmlStudent5.setRegistrationNumber(7343);
		
		xmlStudents.add(xmlStudent1);
		xmlStudents.add(xmlStudent2);
		xmlStudents.add(xmlStudent3);
		xmlStudents.add(xmlStudent4);
		xmlStudents.add(xmlStudent5);
		
		return xmlStudents;
	}
	
	public Marshaller getMarshaller() {
		return marshaller;
	}


	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}


	public Unmarshaller getUnmarshaller() {
		return unmarshaller;
	}


	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}
	
}
