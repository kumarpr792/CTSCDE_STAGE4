package com.cognizant.model;

import org.springframework.stereotype.Component;

@Component
public class Country {

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
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(String code, String name) {

		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
