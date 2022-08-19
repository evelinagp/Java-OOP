package restaurant.entities.drinks;

import restaurant.entities.drinks.interfaces.Beverages;

public abstract class BaseBeverage implements Beverages {

    private String name;
    private int counter;
    private double price;
    private String brand;

    protected BaseBeverage(String name, int counter, double price, String brand) {
        this.setName(name);
        this.setCounter(counter);
        this.setPrice(price);
        this.setBrand(brand);
    }

    private void setBrand(String brand) {

    }

    private void setPrice(double price) {

    }

    private void setCounter(int counter) {

    }

    private void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getCounter() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getBrand() {
        return null;
    }
}
