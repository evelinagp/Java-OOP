package PolymorphismVehiclesEx01;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);

    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 1.6);
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
