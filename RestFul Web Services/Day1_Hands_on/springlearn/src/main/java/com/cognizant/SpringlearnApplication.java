package com.cognizant;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.model.Country;

@SpringBootApplication
public class SpringlearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringlearnApplication.class);
	private static ApplicationContext context;
	private static ApplicationContext context2;
	private static ApplicationContext context3;
	public static void main(String[] args) {
		SpringApplication.run(SpringlearnApplication.class, args);
		displayDate();
		displayCountry();
		displayCountries();
	}
	public static void displayDate() {
		LOGGER.info("Start");
		context = new ClassPathXmlApplicationContext("date_format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date d=format.parse("31/12/2020");
			//System.out.println(format.format(d));
			LOGGER.debug(format.format(d));
			LOGGER.debug(d.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			LOGGER.error("String Parsing Error");
			e.printStackTrace();
		}
		LOGGER.info("End");
	}
	public static void displayCountry(){
		LOGGER.info("Start");
		context2 = new ClassPathXmlApplicationContext("country.xml");
		Country c=context2.getBean("country",Country.class);
		//Country anotherCountry = context2.getBean("country", Country.class);
		LOGGER.debug("Country : {}", c.toString());
		LOGGER.info("End");
		
	}
	public static void displayCountries() {
		LOGGER.info("Start");
		context3 = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> l=context3.getBean("countryList",ArrayList.class);
		LOGGER.debug("Countries : {}", l);
		LOGGER.info("End");
	}
}
