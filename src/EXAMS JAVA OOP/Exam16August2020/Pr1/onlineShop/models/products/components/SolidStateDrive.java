package onlineShop.models.products.components;

public class SolidStateDrive extends BaseComponent {

    private static final double MULTIPLY_SolidStateDrive = 1.20;

    public SolidStateDrive(int id, String manufacturer, String model, double price, int generation) {
        super(id, manufacturer, model, price, MULTIPLY_SolidStateDrive, generation);
    }
    @Override
    public double getOverallPerformance() {
        return super.getOverallPerformance() * MULTIPLY_SolidStateDrive;
    }
}
