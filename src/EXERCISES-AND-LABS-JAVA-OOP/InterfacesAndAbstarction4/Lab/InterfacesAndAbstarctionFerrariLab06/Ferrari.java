package InterfacesAndAbstarction4.Lab.InterfacesAndAbstarctionFerrariLab06;

public class Ferrari implements Car {
//driverName: String
//model: String
    private String driverName;
    private final static String MODEL = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getModel() {
        return MODEL;
    }

//Ferrari (String)
//brakes() : String
//gas() : String
//toString(): String
    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", getModel(),brakes(), gas(), getDriverName());
    }
}
