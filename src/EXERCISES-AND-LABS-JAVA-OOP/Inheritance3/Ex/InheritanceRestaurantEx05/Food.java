package Inheritance3.Ex.InheritanceRestaurantEx05;

import java.math.BigDecimal;

public class Food extends Product {
    //•	grams – double
    private double grams;

    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams = grams;
    }
//•	Getter for grams

    public double getGrams() {
        return grams;
    }
}
