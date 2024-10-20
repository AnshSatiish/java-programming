package exercise1;

abstract class Insurance {
    private String insuranceType;
    private double monthlyCost;

    public Insurance(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public double getMonthlyCost()
    {
        return monthlyCost;
    }

    // Setter method for monthly cost
    public void setMonthlyCost(double cost) {
        this.monthlyCost = cost;
    }

    public abstract void setInsuranceCost();
    public abstract void displayInfo();
}
