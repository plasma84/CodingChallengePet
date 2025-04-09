package entity.model;

public class Cat extends Pet {
    private String catColor;

    // Constructor
    public Cat(String name, int age, String breed, String catColor) {
        super(name, age, breed);
        this.catColor = catColor;
    }

    // Getters and Setters
    public String getCatColor() {
        return catColor;
    }

    public void setCatColor(String catColor) {
        this.catColor = catColor;
    }

    // toString Method
    @Override
    public String toString() {
        return super.toString() + ", CatColor='" + catColor + '\'';
    }
}