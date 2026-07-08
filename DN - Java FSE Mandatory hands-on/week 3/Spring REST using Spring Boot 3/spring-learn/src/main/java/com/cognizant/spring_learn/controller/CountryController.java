package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.CountryService;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Primary Web REST controller managing routing endpoints for the Country module data.
 * Leverages Jackson serialization libraries to automatically output entities as clean JSON text structures.
 */
@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    /**
     * Fulfills the target Country Web Service requirements by retrieving a fixed metadata bean directly.
     * Maps incoming traffic arriving at the '/country' route using the standard RequestMapping definition.
     *
     * @return Documented instance structure containing hardcoded bean choices for India.
     */
    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START - Triggering explicit getCountryIndia route parsing");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);

        LOGGER.info("END - Successfully completed getCountryIndia structural return loop");
        return country;
    }

    /**
     * Fulfills the dynamic parameterized lookup service milestone task parameters.
     * Captures incoming URL segment variables case-insensitively and passes them directly to the backend layer.
     *
     * @param code Path parameter segment representing the desired country code.
     * @return Target matching instance payload details.
     * @throws CountryNotFoundException if data lookup checks fail validation requirements.
     */
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START - Capturing URL path variable lookup route parameter: {}", code);

        Country dynamicMatch = countryService.getCountry(code);

        LOGGER.info("END - Successfully mapped dynamic parameter payload validation checks");
        return dynamicMatch;
    }
}