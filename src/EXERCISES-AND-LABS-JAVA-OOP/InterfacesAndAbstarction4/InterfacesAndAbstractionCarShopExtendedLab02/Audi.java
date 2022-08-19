package InterfacesAndAbstractionCarShopExtendedLab02;

public class Audi extends CarImpl implements Rentable {
    //    -minRentDay: Integer
    private Integer minRentDay;
    //-pricePerDay: Double
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return null;
    }

    @Override
    public Double getPricePerDay() {
        return null;
    }

    //+toString(): String
    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Minimum rental period of " + minRentDay + " days. Price per day " + pricePerDay;
    }
}
