package entity.model;

import util.DBConnUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class PetShelter {
    private static final String DB_PROPERTIES_FILE = "db.properties";

    // Add a pet to the shelter and database
    public void addPet(Pet pet) throws ClassNotFoundException {
        String query = "INSERT INTO pets (name, age, breed) VALUES (?, ?, ?)";
        try (Connection conn = DBConnUtil.getConnection(DB_PROPERTIES_FILE);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pet.getName());
            stmt.setInt(2, pet.getAge());
            stmt.setString(3, pet.getBreed());
            stmt.executeUpdate();
            System.out.println("Pet added to the database successfully.");
        } catch (SQLException | IOException e) {
            System.out.println("Error adding pet to the database: " + e.getMessage());
        }
    }

    // List all available pets from the database
    public List<Pet> listAvailablePets() throws ClassNotFoundException {
        List<Pet> pets = new ArrayList<>();
        String query = "SELECT * FROM pets";
        try (Connection conn = DBConnUtil.getConnection(DB_PROPERTIES_FILE);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String breed = rs.getString("breed");
                pets.add(new Pet(name, age, breed));
            }
        } catch (SQLException | IOException e) {
            System.out.println("Error retrieving pets from the database: " + e.getMessage());
        }
        return pets;
    }

    // Remove a pet from the shelter and database
    public void removePet(Pet pet) throws ClassNotFoundException {
        String query = "DELETE FROM pets WHERE name = ? AND age = ? AND breed = ?";
        try (Connection conn = DBConnUtil.getConnection(DB_PROPERTIES_FILE);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pet.getName());
            stmt.setInt(2, pet.getAge());
            stmt.setString(3, pet.getBreed());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pet removed from the database successfully.");
            } else {
                System.out.println("Pet not found in the database.");
            }
        } catch (SQLException | IOException e) {
            System.out.println("Error removing pet from the database: " + e.getMessage());
        }
    }
}