package onlineShop.models.products.components;

public class RandomAccessMemory extends BaseComponent {

    private static final double MULTIPLY_RandomAccessMemory = 1.20;

    public RandomAccessMemory(int id, String manufacturer, String model, double price, int generation) {
        super(id, manufacturer, model, price, MULTIPLY_RandomAccessMemory, generation);
    }

    @Override
    public double getOverallPerformance() {
        return super.getOverallPerformance() * MULTIPLY_RandomAccessMemory;
    }
}
