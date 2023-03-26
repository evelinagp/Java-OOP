package Polimorphism5.Ex.PolymorphismVehiclesEx01;

public class Car extends Vehicle implements VehicleImpl {
    private static final double CAR_INCREASING_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }
    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + CAR_INCREASING_CONSUMPTION);
    }

    @Override
    public String drive(double distance) {
        return "Car " + super.drive(distance);
    }
}
