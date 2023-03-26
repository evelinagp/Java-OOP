package Polimorphism5.Ex.PolymorphismVehiclesEx01;

import java.text.DecimalFormat;

public class Vehicle implements VehicleImpl {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;
        DecimalFormat df = new DecimalFormat("#.##");
        String result = "needs refueling";
        if (this.fuelQuantity >= fuelNeeded) {
            result = String.format("travelled %s km", df.format(distance));
            this.fuelQuantity -= fuelNeeded;
        }
        return result;
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
    //    Car and truck both have fuel quantity, fuel consumption in liters per km and can be driven given distance
//    and refueled with given liters. But in the summer both vehicles use air conditioner and their fuel consumption
//    per km is increased by 0.9 liters for the car and with 1.6 liters for the truck. Also the truck has a tiny hole
//    in his tank and when it gets refueled it gets only 95% of given fuel. The car has no problems when refueling and adds
//    all given fuel to its tank. If vehicle cannot travel given distance its fuel does not change.

