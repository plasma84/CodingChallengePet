package dao;

import entity.model.Donation;
import entity.model.CashDonation;
import entity.model.ItemDonation;
import exception.AdoptionException;
import util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonationDAOImpl implements DonationDAO {
    private static final String DB_PROPERTIES_FILE = "db.properties";

    @Override
    public void recordDonation(Donation donation) throws AdoptionException {
        String query = "INSERT INTO donations (donor_name, amount, donation_type, donation_date, item_type) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnUtil.getConnection(DB_PROPERTIES_FILE);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, donation.getDonorName());
            stmt.setDouble(2, donation.getAmount());
            if (donation instanceof CashDonation) {
                stmt.setString(3, "Cash");
                stmt.setDate(4, Date.valueOf(((CashDonation) donation).getDonationDate()));
                stmt.setString(5, null);
            } else if (donation instanceof ItemDonation) {
                stmt.setString(3, "Item");
                stmt.setDate(4, null);
                stmt.setString(5, ((ItemDonation) donation).getItemType());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new AdoptionException("Error recording donation in the database: " + e.getMessage());
        } catch (Exception e) {
            throw new AdoptionException("Unexpected error: " + e.getMessage());
        }
    }

    @Override
    public List<Donation> listDonations() throws AdoptionException {
        List<Donation> donations = new ArrayList<>();
        String query = "SELECT * FROM donations";
        try (Connection conn = DBConnUtil.getConnection(DB_PROPERTIES_FILE);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String donorName = rs.getString("donor_name");
                double amount = rs.getDouble("amount");
                String donationType = rs.getString("donation_type");
                if ("Cash".equalsIgnoreCase(donationType)) {
                    Date donationDate = rs.getDate("donation_date");
                    donations.add(new CashDonation(donorName, amount, donationDate.toLocalDate()));
                } else if ("Item".equalsIgnoreCase(donationType)) {
                    String itemType = rs.getString("item_type");
                    donations.add(new ItemDonation(donorName, amount, itemType));
                }
            }
        } catch (SQLException e) {
            throw new AdoptionException("Error retrieving donations from the database: " + e.getMessage());
        } catch (Exception e) {
            throw new AdoptionException("Unexpected error: " + e.getMessage());
        }
        return donations;
    }
}