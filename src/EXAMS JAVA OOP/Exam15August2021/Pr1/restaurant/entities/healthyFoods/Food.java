package restaurant.entities.healthyFoods;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

public abstract class Food implements HealthyFood {
    private String name;
    private double portion;
    private double price;

    protected Food(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    private void setPrice(double price) {

    }

    private void setPortion(double portion) {

    }

    private void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPortion() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
