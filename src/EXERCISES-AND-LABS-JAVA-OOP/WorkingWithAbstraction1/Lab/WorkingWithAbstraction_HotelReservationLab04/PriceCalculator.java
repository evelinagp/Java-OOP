package WorkingWithAbstraction1.Lab.WorkingWithAbstraction_HotelReservationLab04;

public class PriceCalculator {
    private Season season;
    private DiscountType discount;
    private double pricePerDay;
    private int days;

    public PriceCalculator(Season season, DiscountType discount, double pricePerDay, int days) {
        this.season = season;
        this.discount = discount;
        this.pricePerDay = pricePerDay;
        this.days = days;
    }

    public String calculatePrice() {
        return String.format("%.2f",this.days * this.pricePerDay * this.season.getMultiplier() * (1 - this.discount.getDiscount() / 100.00));
    }
}
