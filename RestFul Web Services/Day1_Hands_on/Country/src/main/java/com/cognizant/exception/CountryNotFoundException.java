package com.cognizant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Country Not Found")
public class CountryNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public CountryNotFoundException() {
		super("Country Not Found");
	}
	public CountryNotFoundException(String s) {
		super(s);
		
	}
}
