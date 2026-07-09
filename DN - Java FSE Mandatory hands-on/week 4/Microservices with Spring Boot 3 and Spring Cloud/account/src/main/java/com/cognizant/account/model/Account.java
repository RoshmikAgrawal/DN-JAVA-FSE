package com.cognizant.account.model;

/**
 * Data encapsulation model representing a bank Account entity structure.
 * This class follows standard JavaBean specifications, allowing automated
 * serialization into JSON formats by the framework's message converters.
 */
public class Account {

    private String number;
    private String type;
    private double balance;

    /**
     * Default no-argument constructor required for standard reflection
     * and sub-framework object instantiation lifecycles.
     */
    public Account() {
    }

    /**
     * Parameterized constructor to fully initialize the immutable properties
     * of the domain model instance.
     *
     * @param number  The unique account identification string coordinate.
     * @param type    The category classification profile of the account.
     * @param balance The current liquid valuation ledger summary.
     */
    public Account(String number, String type, double balance) {
        this.number = number;
        this.type = type;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}