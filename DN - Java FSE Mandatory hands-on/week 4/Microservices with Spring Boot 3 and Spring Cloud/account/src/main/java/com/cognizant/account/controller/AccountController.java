package com.cognizant.account.controller;

import com.cognizant.account.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Web Controller exposing endpoint interfaces for Account-driven metrics.
 * Annotating with @RestController eliminates the need for redundant @ResponseBody
 * declarations across return statements by ensuring direct response stream binding.
 */
@RestController
public class AccountController {

    /**
     * Handles incoming HTTP GET transmission routing configurations matching the explicit path format.
     * Leverages a dynamic path variable structure to capture parameter metrics directly
     * from incoming network request strings.
     *
     * @param number The targeted account verification string caught from the path segment.
     * @return Fully populated mock Account instance serialized directly into an HTTP JSON payload layout.
     */
    @GetMapping("/accounts/{number}")
    public Account getAccountDetails(@PathVariable String number) {

        // Constructing a standard hardcoded mock entity mapping precisely to the handbook specification sheet rules
        return new Account(number, "savings", 234343.0);
    }
}