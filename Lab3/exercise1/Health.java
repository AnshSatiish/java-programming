package exercise1;

class Health extends Insurance {

    public Health() {
        super("Health Insurance");
    }

    public void setInsuranceCost() {
        setMonthlyCost(150.0);
    }

    public void displayInfo() {
        System.out.println("Insurance Type: " + getInsuranceType());
        System.out.println("Monthly Cost: $" + getMonthlyCost());
    }
}
