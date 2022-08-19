package onlineShop.models.products.components;

public class VideoCard extends BaseComponent {

    private static final double MULTIPLY_VideoCard=1.15;

    public VideoCard(int id, String manufacturer, String model, double price,  int generation) {
        super(id, manufacturer, model, price, MULTIPLY_VideoCard, generation);
    }
    @Override
    public double getOverallPerformance() {
        return super.getOverallPerformance() * MULTIPLY_VideoCard;
    }
}
