package onlineShop.models.products.components;

public class PowerSupply extends BaseComponent {

    private static final double MULTIPLY_PowerSupply=1.05;
    public PowerSupply(int id, String manufacturer, String model, double price, int generation) {
        super(id, manufacturer, model, price, MULTIPLY_PowerSupply, generation);
    }
    @Override
    public double getOverallPerformance() {
        return super.getOverallPerformance() * MULTIPLY_PowerSupply;
    }

}
