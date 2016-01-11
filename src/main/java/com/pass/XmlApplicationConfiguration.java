package com.pass;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.castor.CastorMarshaller;

@Profile("xml-database")
@Configuration
public class XmlApplicationConfiguration {
	
	@Bean
	public XmlConverter getHandler(){
		XmlConverter handler= new XmlConverter();
		handler.setMarshaller(getCastorMarshaller());
		handler.setUnmarshaller(getCastorMarshaller());
		return handler;
	}
	
	@Bean
	public CastorMarshaller getCastorMarshaller() {
		CastorMarshaller castorMarshaller = new CastorMarshaller();
		Resource resource = new ClassPathResource("mapping.xml");
		castorMarshaller.setMappingLocation(resource);
		return castorMarshaller;
	}
	
}
