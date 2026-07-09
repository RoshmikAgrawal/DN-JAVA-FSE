package com.cognizant.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Foundation bootstrap execution coordinator driving the Loan Microservice runtime environment.
 * The @SpringBootApplication annotation acts as a multi-tier catalyst that automates
 * hierarchical component scanning, framework configurations, and module boundary initialization.
 */
@SpringBootApplication
public class LoanApplication {

    /**
     * Primary entry point driving the embedded servlet container lifecycle context.
     * Passes system-level thread arrays straight to the active SpringBoot bootstrap runner engine.
     *
     * @param args Array of configuration string context assignments passed at runtime.
     */
    public static void main(String[] args) {
        SpringApplication.run(LoanApplication.class, args);
    }
}