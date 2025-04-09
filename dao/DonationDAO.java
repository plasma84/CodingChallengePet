package dao;

import entity.model.Donation;
import exception.AdoptionException;
import java.util.List;

public interface DonationDAO {
    void recordDonation(Donation donation) throws AdoptionException;
    List<Donation> listDonations() throws AdoptionException;
}