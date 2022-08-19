package onlineShop.models.products.components;

public class Motherboard extends BaseComponent {
    private static final double MULTIPLY_Motherboard = 1.25;


    public Motherboard(int id, String manufacturer, String model, double price, int generation) {
        super(id, manufacturer, model, price, MULTIPLY_Motherboard, generation);
    }

    @Override
    public double getOverallPerformance() {
        return super.getOverallPerformance() * MULTIPLY_Motherboard;
    }
}
