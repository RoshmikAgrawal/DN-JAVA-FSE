package com.cognizant.loan.controller;

import com.cognizant.loan.model.Loan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Web Controller exposing operational endpoint interfaces for the Loan module.
 * Utilizing @RestController ensures that all returned Java entities are automatically
 * intercepted and serialized into HTTP response payloads by Jackson libraries.
 */
@RestController
public class LoanController {

    /**
     * Processes inbound HTTP GET transaction requests routing to the parameterized path.
     * Binds the runtime path segment matrix directly into the method string signature via @PathVariable.
     *
     * @param number Dynamic route variable capturing the target loan record identifier.
     * @return Hardcoded mock entity response structure matching the laboratory handbook requirements.
     */
    @GetMapping("/loans/{number}")
    public Loan getLoanDetails(@PathVariable String number) {

        // Formulating standard mock data metrics matching the expected dummy payload dictionary layout
        return new Loan(number, "car", 400000.0, 3258.0, 18);
    }
}