package Main;

import entity.model.*;
import exception.*;
import util.*;
import dao.PetDAOImpl;
import dao.DonationDAOImpl;
import dao.AdoptionEventDAOImpl;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PetDAOImpl petDAO = new PetDAOImpl();
        DonationDAOImpl donationDAO = new DonationDAOImpl();
        AdoptionEventDAOImpl eventDAO = new AdoptionEventDAOImpl();

        while (true) {
            System.out.println("\n--- PetPals Menu ---");
            System.out.println("1. Add Pet");
            System.out.println("2. Remove Pet");
            System.out.println("3. List Available Pets");
            System.out.println("4. Record Donation");
            System.out.println("5. List Donations");
            System.out.println("6. Add Adoption Event");
            System.out.println("7. List Adoption Events");
            System.out.println("8. Register for Adoption Event");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    // Add Pet
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
                        petDAO.addPet(pet);
                        System.out.println("Pet added successfully.");
                    } catch (InvalidPetAgeException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Database error: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Remove Pet
                    System.out.print("Enter pet name to remove: ");
                    String petNameToRemove = scanner.nextLine();
                    Pet petToRemove = null;

                    try {
                        for (Pet pet : petDAO.listPets()) {
                            if (pet.getName().equalsIgnoreCase(petNameToRemove)) {
                                petToRemove = pet;
                                break;
                            }
                        }

                        if (petToRemove != null) {
                            petDAO.removePet(petToRemove);
                            System.out.println("Pet removed successfully.");
                        } else {
                            System.out.println("Pet not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Database error: " + e.getMessage());
                    }
                    break;

                case 3:
                    // List Available Pets
                    System.out.println("\nAvailable Pets:");
                    try {
                        for (Pet pet : petDAO.listPets()) {
                            System.out.println(pet);
                        }
                    } catch (Exception e) {
                        System.out.println("Database error: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Record Donation
                    System.out.print("Enter donor name: ");
                    String donorName = scanner.nextLine();
                    System.out.print("Enter donation amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter donation type (Cash/Item): ");
                    String donationType = scanner.nextLine();

                    try {
                        if ("Cash".equalsIgnoreCase(donationType)) {
                            System.out.print("Enter donation date (YYYY-MM-DD): ");
                            LocalDate donationDate = LocalDate.parse(scanner.nextLine());
                            donationDAO.recordDonation(new CashDonation(donorName, amount, donationDate));
                        } else if ("Item".equalsIgnoreCase(donationType)) {
                            System.out.print("Enter item type: ");
                            String itemType = scanner.nextLine();
                            donationDAO.recordDonation(new ItemDonation(donorName, amount, itemType));
                        } else {
                            System.out.println("Invalid donation type.");
                        }
                    } catch (Exception e) {
                        System.out.println("Database error: " + e.getMessage());
                    }
                    break;

                case 5:
                    // List Donations
                    System.out.println("\nDonations:");
                    try {
                        for (Donation donation : donationDAO.listDonations()) {
                            System.out.println(donation);
                        }
                    } catch (Exception e) {
                        System.out.println("Database error: " + e.getMessage());
                    }
                    break;

                case 6:
                    // Add Adoption Event
                    System.out.print("Enter event name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter event date (YYYY-MM-DD): ");
                    LocalDate eventDate = LocalDate.parse(scanner.nextLine());

                    try {
                        eventDAO.addEvent(new AdoptionEvent(eventName, eventDate));
                        System.out.println("Adoption event added successfully.");
                    } catch (Exception e) {
                        System.out.println("Database error: " + e.getMessage());
                    }
                    break;

                case 7:
                    // List Adoption Events
                    System.out.println("\nAdoption Events:");
                    try {
                        for (AdoptionEvent event : eventDAO.listEvents()) {
                            System.out.println(event);
                        }
                    } catch (Exception e) {
                        System.out.println("Database error: " + e.getMessage());
                    }
                    break;

                case 8:
                    // Register for Adoption Event
                    System.out.print("Enter event ID: ");
                    int eventId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter participant name: ");
                    String participantName = scanner.nextLine();

                    try {
                        eventDAO.registerParticipant(eventId, participantName);
                        System.out.println("Participant registered successfully.");
                    } catch (Exception e) {
                        System.out.println("Database error: " + e.getMessage());
                    }
                    break;

                case 9:
                    // Exit
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}