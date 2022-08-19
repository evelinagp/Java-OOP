package onlineShop.models.products.components;


public class CentralProcessingUnit extends BaseComponent {

    private static final double MULTIPLY_CentralProcessingUnit = 1.25;

    public CentralProcessingUnit(int id, String manufacturer, String model, double price, int generation) {
        super(id, manufacturer, model, price, MULTIPLY_CentralProcessingUnit, generation);
    }

    @Override
    public double getOverallPerformance() {
        return super.getOverallPerformance() * MULTIPLY_CentralProcessingUnit;
    }
}
