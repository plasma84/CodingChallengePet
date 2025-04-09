package Main;

import entity.model.*;
import exception.*;
import util.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetShelter shelter = new PetShelter();

        while (true) {
            System.out.println("\n--- PetPals Menu ---");
            System.out.println("1. Add Pet");
            System.out.println("2. Remove Pet");
            System.out.println("3. List Available Pets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter pet name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter pet age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter pet breed: ");
                    String breed = scanner.nextLine();

                    try {
                        if (age <= 0) {
                            throw new InvalidPetAgeException("Age must be a positive integer.");
                        }
                        Pet pet = new Pet(name, age, breed);
                        shelter.addPet(pet);
                        System.out.println("Pet added successfully.");
                    } catch (InvalidPetAgeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter pet name to remove: ");
                    String petNameToRemove = scanner.nextLine();
                    Pet petToRemove = null;

                    for (Pet pet : shelter.listAvailablePets()) {
                        if (pet.getName().equalsIgnoreCase(petNameToRemove)) {
                            petToRemove = pet;
                            break;
                        }
                    }

                    if (petToRemove != null) {
                        shelter.removePet(petToRemove);
                        System.out.println("Pet removed successfully.");
                    } else {
                        System.out.println("Pet not found.");
                    }
                    break;

                case 3:
                    System.out.println("\nAvailable Pets:");
                    for (Pet pet : shelter.listAvailablePets()) {
                        System.out.println(pet);
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}