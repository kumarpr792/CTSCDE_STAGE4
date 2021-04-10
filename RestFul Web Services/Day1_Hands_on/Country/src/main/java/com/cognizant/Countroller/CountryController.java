package com.cognizant.Countroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.CountryNotFoundException;
import com.cognizant.model.Country;
import com.cognizant.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService cs;

	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public Country getCountryIndia() {
		return cs.getCountryIndia();
	}

	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public List<Country> getAllCountries() {
		return cs.getAllCountries();
	}

	@RequestMapping(value = "/country/{code}", method = RequestMethod.GET)
	public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
				return cs.getCountryByCode(code);
		
	}
}
