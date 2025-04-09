package entity.model;

public abstract class Donation {
    private String donorName;
    private double amount;

    // Constructor
    public Donation(String donorName, double amount) {
        this.donorName = donorName;
        this.amount = amount;
    }

    // Getters and Setters
    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Abstract method
    public abstract void recordDonation();
}