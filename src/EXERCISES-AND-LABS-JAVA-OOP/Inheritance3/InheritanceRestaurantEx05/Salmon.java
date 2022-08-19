package InheritanceRestaurantEx05;

import java.math.BigDecimal;

public class Salmon extends MainDish {
    protected static final double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }
}
