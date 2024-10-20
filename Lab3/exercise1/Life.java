package exercise1;

class Life extends Insurance {
    public Life(String type) {
        super("Life Insurance");
    }

    public void setInsuranceCost() {
        setMonthlyCost(200.0);
    }

    public void displayInfo() {
        System.out.println("Insurance Type: " + getInsuranceType());
        System.out.println("Monthly Cost: $" + getMonthlyCost());
    }
}
