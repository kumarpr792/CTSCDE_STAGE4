package com.cognizant.Countroller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.CountryNotFoundException;
import com.cognizant.model.Country;

@RestController
public class CountryController {

	private ApplicationContext c;

	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public Country getCountryIndia() {
		c = new ClassPathXmlApplicationContext("country.xml");
		Country in = (Country) c.getBean("in");
		return in;
	}

	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public List<Country> getAllCountries() {
		c = new ClassPathXmlApplicationContext("country.xml");
		List<Country> l = c.getBean("countryList", java.util.ArrayList.class);
		return l;
	}

	@RequestMapping(value = "/country/{code}", method = RequestMethod.GET)
	public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
		c = new ClassPathXmlApplicationContext("country.xml");
		List<Country> l = c.getBean("countryList", java.util.ArrayList.class);
		for (Country i : l) {
			if (i.getCode().equalsIgnoreCase(code))
				return i;
		}
		throw new CountryNotFoundException();
	}
}
