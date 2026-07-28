package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("country.xml");

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);

		displayCountry();
		displayCountries();
	}

	public static void displayCountry() {
		LOGGER.info("START - displayCountry");
		// Reuse the global container instance
		Country country = CONTEXT.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		LOGGER.info("END - displayCountry");
	}

	public static void displayCountries() {
		LOGGER.info("START - displayCountries");
		// Reuse the global container instance
		@SuppressWarnings("unchecked")
		List<Country> countries = CONTEXT.getBean("countryList", ArrayList.class);
		LOGGER.debug("Countries Data: {}", countries);
		LOGGER.info("END - displayCountries");
	}
}