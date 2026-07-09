package com.cognizant.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application bootstrap coordinator initializing the Account Microservice environment.
 * The @SpringBootApplication meta-annotation integrates component scanning,
 * autoconfiguration rules, and centralized configuration properties loading.
 */
@SpringBootApplication
public class AccountApplication {

    /**
     * Primary runtime execution loop initializing the embedded application container context.
     * Delegates bootstrap orchestrations to the SpringApplication foundation manager engine.
     *
     * @param args System-level configuration array string references passed during execution initialization.
     */
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}