package entity.model;

public class ItemDonation extends Donation {
    private String itemType;

    // Constructor
    public ItemDonation(String donorName, double amount, String itemType) {
        super(donorName, amount);
        this.itemType = itemType;
    }

    // Getters and Setters
    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    // Implementation of recordDonation
    @Override
    public void recordDonation() {
        System.out.println("Item donation recorded: " + itemType + " worth " + getAmount() + " by " + getDonorName());
    }
}