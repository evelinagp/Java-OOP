package Inheritance3.Ex.InheritanceRestaurantEx05;

import java.math.BigDecimal;

public class Product {
//•	name – String
//•	price – BigDecimal
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    //•	Getters for the fields

}
