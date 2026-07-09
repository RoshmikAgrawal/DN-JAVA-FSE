package com.cognizant.loan;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Integration test component validated during the Maven testing phase execution lifecycle.
 * Ensures the foundational Spring Boot ApplicationContext for the Loan Microservice
 * initializes cleanly without configuration anomalies.
 */
@SpringBootTest
class LoanApplicationTests {

    /**
     * Baseline diagnostic verification check.
     * Successful completion guarantees that all web controller layers and component
     * configurations are correctly mapped by the container registry.
     */
    @Test
    void contextLoads() {
        // Context validation is performed implicitly by the framework startup sequence.
    }
}