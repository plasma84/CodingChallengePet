package entity.model;

public class Dog extends Pet {
    private String dogBreed;

    // Constructor
    public Dog(String name, int age, String breed, String dogBreed) {
        super(name, age, breed);
        this.dogBreed = dogBreed;
    }

    // Getters and Setters
    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    // toString Method
    @Override
    public String toString() {
        return super.toString() + ", DogBreed='" + dogBreed + '\'';
    }
}