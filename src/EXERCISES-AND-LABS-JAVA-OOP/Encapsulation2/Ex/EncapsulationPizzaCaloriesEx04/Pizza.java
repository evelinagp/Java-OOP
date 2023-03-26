package Encapsulation2.Ex.EncapsulationPizzaCaloriesEx04;

import java.util.ArrayList;
import java.util.List;

//Pizza
public class Pizza {
//-	name: String
//-	dought:  Dough
//-	toppings: List<Topping>
    private String name;
    private Dough doughs;
    private List<Topping> toppings;

//+ 	Pizza (String, int numberOfToppings)
    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    //-	setName(String) : void
    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    //-	setToppings(int) : void
    public void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    //+	setDough(Dough) : void
    public void setDough(Dough doughs) {
        this.doughs = doughs;
    }

    //+	getName(): String
    public String getName() {
        return this.name;
    }

    //+	addTopping (Topping) : void
    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    //+	getOverallCalories () : double
    public double getOverallCalories() {
        return this.doughs.calculateCalories() + this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }
}
