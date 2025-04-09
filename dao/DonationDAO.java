package dao;

import entity.model.Donation;
import java.util.List;

public interface DonationDAO {
    void recordDonation(Donation donation) throws Exception;
    List<Donation> listDonations() throws Exception;
}