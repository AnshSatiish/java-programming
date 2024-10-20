package exercise3;

// Class for business mortgages
public class BusinessMortgage extends Mortgage {
    public BusinessMortgage(String mortgageNumber, String customerName, double amount, int term) {
        super(mortgageNumber, customerName, amount, term);
    }

    @Override
    protected double calculateInterestRate() {
        return 0.01; // 1% over the current prime rate
    }
}