package EncapsulationShoppingSpreeEx03;

public class Product {
    //name: String
//cost: double
    private String name;
    private double cost;


//+ Product (String,  double)
//-	setCost (double): void
//-	setName (String): void
//+	getName(): String
//+	getCost (): double

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setCost(double cost) {
        Validator.validateMoney(cost);
        this.cost = cost;
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
