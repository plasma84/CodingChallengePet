package dao;

import entity.model.Pet;
import exception.AdoptionException;
import java.util.List;

public interface PetDAO {
    void addPet(Pet pet) throws AdoptionException;
    void removePet(Pet pet) throws AdoptionException;
    List<Pet> listPets() throws AdoptionException;
}