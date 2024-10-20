package exercise3;

// Abstract class representing a mortgage
public abstract class Mortgage implements MortgageConstants {
    protected String mortgageNumber;
    protected String customerName;
    protected double amount;
    protected double interestRate;
    protected int term;

    public Mortgage(String mortgageNumber, String customerName, double amount, int term) {
        if (amount > MAX_MORTGAGE_AMOUNT) {
            throw new IllegalArgumentException("Mortgage amount cannot exceed " + MAX_MORTGAGE_AMOUNT);
        }
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.amount = amount;
        this.term = (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM) ? term : SHORT_TERM;
        this.interestRate = calculateInterestRate();
    }

    protected abstract double calculateInterestRate();

    public double getTotalAmountOwed() {
        return amount + (amount * interestRate * term);
    }

    public String getMortgageInfo() {
        return "Mortgage Number: " + mortgageNumber +
                "\nCustomer Name: " + customerName +
                "\nAmount: $" + amount +
                "\nInterest Rate: " + (interestRate * 100) + "%" +
                "\nTerm: " + term + " years" +
                "\nTotal Amount Owed: $" + getTotalAmountOwed();
    }
}