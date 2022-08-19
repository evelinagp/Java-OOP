package InheritanceRestaurantEx05;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {
    private double caffeine;
    protected final static double COFFEE_MILLILITERS = 50;
    protected final static BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);


    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        this.caffeine = caffeine;
    }

    public double getCaffeine() {
        return caffeine;
    }
}
