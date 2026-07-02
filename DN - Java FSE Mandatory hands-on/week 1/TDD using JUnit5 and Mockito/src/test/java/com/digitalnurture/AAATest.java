package com.digitalnurture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AAATest {
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount(1000.00);
    }

    @AfterEach
    public void tearDown() {
        account = null;
    }

    @Test
    public void testWithdrawalUsingAAAPattern() {
        double withdrawalAmount = 250.00;
        double expectedBalance = 750.00;

        account.withdraw(withdrawalAmount);

        assertEquals(expectedBalance, account.getBalance());
    }
}
