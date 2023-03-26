package Polimorphism5.Ex.PolymorphismVehiclesEx01;

public class Truck extends Vehicle {
    private static final double TRUCK_INCREASING_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);

    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + TRUCK_INCREASING_CONSUMPTION);
    }

    @Override
    public String drive(double distance) {
        return "Truck " + super.drive(distance);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
