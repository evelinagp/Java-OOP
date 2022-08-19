package onlineShop.models.products.computers;

public class DesktopComputer extends BaseComputer {
    private static final double DesktopComputer = 15;

    public DesktopComputer(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, DesktopComputer);
    }

    @Override
    public double getOverallPerformance() {
        return super.getOverallPerformance() * DesktopComputer;
    }
}