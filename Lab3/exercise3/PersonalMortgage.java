package exercise3;

// Class for personal mortgages
public class PersonalMortgage extends Mortgage {
    public PersonalMortgage(String mortgageNumber, String customerName, double amount, int term) {
        super(mortgageNumber, customerName, amount, term);
    }

    @Override
    protected double calculateInterestRate() {
        return 0.02; // 2% over the current prime rate
    }
}