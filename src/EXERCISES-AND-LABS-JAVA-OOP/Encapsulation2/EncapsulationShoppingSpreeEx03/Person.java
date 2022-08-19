package EncapsulationShoppingSpreeEx03;
//+	getName(): String

import java.util.ArrayList;
import java.util.List;

// Person
public class Person {
    //-	name: String
//-	money:  double
//-	products:  List<Product>
    private String name;
    private double money;
    private List<Product> products;

    //+ Person (String ,  double)
//-	setName (String) : void
//-	setMoney (double) : void
    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setMoney(double money) {
        this.money = money;
        Validator.validateMoney(money);
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //+	buyProduct (Product) : void
    public void buyProduct(Product product) {
       if (this.money < product.getCost()){
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
       }
       this.money -= product.getCost();
       this.products.add(product);
    }
}
