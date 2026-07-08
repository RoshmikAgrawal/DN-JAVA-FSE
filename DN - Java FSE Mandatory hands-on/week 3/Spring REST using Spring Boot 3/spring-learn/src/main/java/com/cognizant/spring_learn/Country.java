package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    // Injecting the SLF4J logger engine for diagnostic tracking
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    // Strict Rule: Empty parameter constructor with mandatory debug log message
    public Country() {
        LOGGER.debug("Inside Country Constructor."); //
    }

    // Getter with custom internal validation logging
    public String getCode() {
        LOGGER.debug("Retrieving Country Code: {}", this.code);
        return code;
    }

    // Setter with custom parameter mutation logging
    public void setCode(String code) {
        LOGGER.debug("Setting Country Code to: {}", code); //
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Retrieving Country Name: {}", this.name);
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Setting Country Name to: {}", name); //
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" + "code='" + code + '\'' + ", name='" + name + '\'' + '}';
    }
}