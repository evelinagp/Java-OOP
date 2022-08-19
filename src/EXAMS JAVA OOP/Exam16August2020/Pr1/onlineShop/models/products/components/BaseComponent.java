package onlineShop.models.products.components;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;

public abstract class BaseComponent extends BaseProduct implements Component {
    private int generation;

    protected BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
    }


    @Override
    public int getGeneration() {
        return 0;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getManufacturer() {
        return null;
    }

    @Override
    public String getModel() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }


    @Override
    public String toString() {
        return "Override toString() method in the format:\n" +
                "\"Overall Performance: {overall performance}. " +
                "Price: {price} - {product type}: {manufacturer} {model}" +
                " (Id: {id}) Generation: {generation}\"\n";
    }
}
