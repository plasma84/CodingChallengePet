package entity.model;

import java.time.LocalDate;

public class CashDonation extends Donation {
    private LocalDate donationDate;

    // Constructor
    public CashDonation(String donorName, double amount, LocalDate donationDate) {
        super(donorName, amount);
        this.donationDate = donationDate;
    }

    // Getters and Setters
    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    // Implementation of recordDonation
    @Override
    public void recordDonation() {
        System.out.println("Cash donation recorded: " + getAmount() + " by " + getDonorName() + " on " + donationDate);
    }
}