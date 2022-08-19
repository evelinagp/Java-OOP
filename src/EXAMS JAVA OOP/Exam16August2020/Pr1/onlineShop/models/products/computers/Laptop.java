package onlineShop.models.products.computers;

public class Laptop extends BaseComputer {
    private static final double Laptop = 10;

    public Laptop(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, Laptop);
    }

    @Override
    public double getOverallPerformance() {
        return super.getOverallPerformance() * Laptop;
    }
}
