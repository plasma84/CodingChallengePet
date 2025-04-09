package dao;

import entity.model.Pet;
import util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAOImpl implements PetDAO {
    private static final String DB_PROPERTIES_FILE = "db.properties";

    @Override
    public void addPet(Pet pet) throws Exception {
        String query = "INSERT INTO pets (name, age, breed) VALUES (?, ?, ?)";
        try (Connection conn = DBConnUtil.getConnection(DB_PROPERTIES_FILE);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pet.getName());
            stmt.setInt(2, pet.getAge());
            stmt.setString(3, pet.getBreed());
            stmt.executeUpdate();
        }
    }

    @Override
    public void removePet(Pet pet) throws Exception {
        String query = "DELETE FROM pets WHERE name = ? AND age = ? AND breed = ?";
        try (Connection conn = DBConnUtil.getConnection(DB_PROPERTIES_FILE);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pet.getName());
            stmt.setInt(2, pet.getAge());
            stmt.setString(3, pet.getBreed());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Pet> listPets() throws Exception {
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
        }
        return pets;
    }
}