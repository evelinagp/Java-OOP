package Encapsulation2.Ex.EncapsulationPizzaCaloriesEx04;

//    Topping
public class Topping {
    //   - toppingType: String
//   - weight: double
    private String toppingType;
    private double weight;

    //  +  Topping (String, double)
    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    //   - setWeight (double): void
    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    //   - setToppingType (String): void
    private void setToppingType(String toppingType) {
        if (!"Meat".equals(toppingType) && !"Veggies".equals(toppingType)
                && !"Cheese".equals(toppingType) && !"Sauce".equals(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    //    + calculateCalories (): double
    public double calculateCalories() {
        return this.weight * 2 * this.getToppingsModifiersByToppingType(this.toppingType);
    }

    private double getToppingsModifiersByToppingType(String toppingType) {

        switch (toppingType) {
            case "Meat":
                return 1.2;
            case "Veggies":
                return 0.8;
            case "Cheese":
                return 1.1;
            case "Sauce":
                return 0.9;
            default:
                return 0.0;
        }
    }
}
