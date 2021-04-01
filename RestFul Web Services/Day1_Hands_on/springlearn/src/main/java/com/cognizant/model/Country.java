package com.cognizant.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.SpringlearnApplication;

@Component
public class Country {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringlearnApplication.class);
	private String code;
	private String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country() {
		LOGGER.debug("Inside the Counstructor");
		//super();
		// TODO Auto-generated constructor stub
	}
	public Country(String code, String name) {
		LOGGER.debug("Inside the Counstructor");
		this.code = code;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
}
