package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service component class managing core business logic related to Country registries.
 * Encapsulates XML metadata ingestion and functional stream filtering protocols.
 */
@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    private final List<Country> countries;

    /**
     * Initializes the service by reading the managed database collection from the XML metadata context.
     */
    @SuppressWarnings("unchecked")
    public CountryService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        this.countries = context.getBean("countryList", ArrayList.class);
    }

    /**
     * Performs a case-insensitive search through the collection registry via a functional stream.
     * Throws a specialized exception if no matching ISO code matches the query criteria.
     *
     * @param code Two-character target ISO code segment provided by the endpoint path.
     * @return Fully populated Country entity instance matching the structural code rules.
     * @throws CountryNotFoundException if the target code does not map to any active record.
     */
    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START - Executing service lookup for code: {}", code);

        Country match = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Target identifier code not present inside registries."));

        LOGGER.debug("Target record match found details: {}", match);
        LOGGER.info("END - Service data search successfully resolved");
        return match;
    }
}