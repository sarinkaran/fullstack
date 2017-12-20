package com.sapient.fullstack.refData;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FullstackRefDataApplication {

	@Value("${server.port}")
	private String port;
	
	public static void main(String[] args) {
		SpringApplication.run(FullstackRefDataApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "hello I am up on " + port;
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
