package com.cognizant.loan.model;

/**
 * Data encapsulation model representing a bank Loan entity structure.
 * Conforms to the standard JavaBean design principles to facilitate automated
 * serialization into JSON strings by web message converters.
 */
public class Loan {

    private String number;
    private String type;
    private double loan;
    private double emi;
    private int tenure;

    /**
     * Default no-argument constructor required by serialization frameworks
     * and Java Reflection mechanisms during runtime object instantiation.
     */
    public Loan() {
    }

    /**
     * Parameterized constructor designed to initialize a populated state instance
     * of the Loan data transfer object.
     *
     * @param number The unique loan account number identifier.
     * @param type   The operational category of the loan resource.
     * @param loan   The total principal valuation amount sanctioned.
     * @param emi    The calculated Equated Monthly稳 Instalment amount ledger value.
     * @param tenure The structured repayment timeline duration measured in months.
     */
    public Loan(String number, String type, double loan, double emi, int tenure) {
        this.number = number;
        this.type = type;
        this.loan = loan;
        this.emi = emi;
        this.tenure = tenure;
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

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", loan=" + loan +
                ", emi=" + emi +
                ", tenure=" + tenure +
                '}';
    }
}