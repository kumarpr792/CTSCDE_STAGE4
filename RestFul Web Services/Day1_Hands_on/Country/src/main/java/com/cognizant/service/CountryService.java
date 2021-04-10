package com.cognizant.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.exception.CountryNotFoundException;
import com.cognizant.model.Country;

@Service
public class CountryService {

	private ApplicationContext c;
	
	public Country getCountryIndia() {
		c = new ClassPathXmlApplicationContext("country.xml");
		Country in = (Country) c.getBean("in");
		return in;
	}
	
	public List<Country> getAllCountries() {
		c = new ClassPathXmlApplicationContext("country.xml");
		List<Country> l = c.getBean("countryList", java.util.ArrayList.class);
		return l;
	}
	public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
		c = new ClassPathXmlApplicationContext("country.xml");
		List<Country> l = c.getBean("countryList", java.util.ArrayList.class);
		for (Country i : l) {
			if (i.getCode().equalsIgnoreCase(code))
				return i;
		}
		throw new CountryNotFoundException("Country Not Found");
	}
}
