package Polimorphism5.Lab.PolimorfismAnimalsLab03;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public String getName() {
        return name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public String explainSelf() {
        return "I am " + getName() + " and my favourite food is " + getFavouriteFood() + System.lineSeparator();
    }
}
