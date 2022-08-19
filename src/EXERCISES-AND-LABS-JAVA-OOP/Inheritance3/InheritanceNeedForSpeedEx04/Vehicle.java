package InheritanceNeedForSpeedEx04;

public class Vehicle {
    //•	DEFAULT_FUEL_CONSUMPTION – final static double (constant)
//•	fuelConsumption –double
//•	fuel – double
//•	horsePower – int
    protected final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.setFuel(fuel);
        this.setHorsePower(horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    public static double getDefaultFuelConsumption() {
        return DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers) {
        double usedFuel = kilometers * fuelConsumption;
//        проверка дали имаме гориво
        if (fuel >= usedFuel){
            //        да го намалим
            fuel-= usedFuel;
        }
    }
}


//•	Getters and Setters for the fields
//•	A public constructor which accepts (fuel, horsePower) and set the default fuel consumption on the field fuelConsumption
//•	void drive(double kilometers)
//o	The drive method should have a functionality to reduce the fuel based on the travelled kilometers and fuel consumption.
// Keep in mind that you can drive the vehicle only if you have enough fuel to finish the driving.
//The default fuel consumption for Vehicle is 1.25. Some of the classes have different default fuel consumption:
//•	SportCar – DEFAULT_FUEL_CONSUMPTION = 10
//•	RaceMotorcycle – DEFAULT_FUEL_CONSUMPTION = 8
//•	Car – DEFAULT_FUEL_CONSUMPTION = 3
//Zip your package and upload it in Judge.
//Hint
//In the child classes' constructors use super.setFuelConsumption() to set fuelConsumption