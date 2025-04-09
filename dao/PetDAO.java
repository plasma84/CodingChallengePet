package dao;

import entity.model.Pet;
import java.util.List;

public interface PetDAO {
    void addPet(Pet pet) throws Exception;
    void removePet(Pet pet) throws Exception;
    List<Pet> listPets() throws Exception;
}