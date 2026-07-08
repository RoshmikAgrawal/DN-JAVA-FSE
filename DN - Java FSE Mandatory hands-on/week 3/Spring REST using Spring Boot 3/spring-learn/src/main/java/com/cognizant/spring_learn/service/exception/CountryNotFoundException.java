package com.cognizant.spring_learn.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom application exception designed to handle exceptional REST data lookup scenarios.
 * Annotating the class with ResponseStatus instructs the framework to automatically
 * translate this exception into an HTTP 404 Not Found error state when thrown.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends Exception {

    /**
     * Constructs a new exception with a specified technical diagnostic message.
     *
     * @param message Detailed context indicating the reason for lookup failure.
     */
    public CountryNotFoundException(String message) {
        super(message);
    }
}