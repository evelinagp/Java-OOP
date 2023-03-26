package Inheritance3.Ex.InheritanceNeedForSpeedEx04;

public class RaceMotorcycle extends Motorcycle {
    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(8);
    }
}
