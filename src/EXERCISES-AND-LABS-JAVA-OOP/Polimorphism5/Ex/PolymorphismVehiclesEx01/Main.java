package Polimorphism5.Ex.PolymorphismVehiclesEx01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    if (tokens[1].equals("Car")) {
                        System.out.println(car.drive(distance));
                    } else if (tokens[1].equals("Truck")) {
                        System.out.println(truck.drive(distance));
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(tokens[2]);
                    if (tokens[1].equals("Car")) {
                        car.refuel(liters);
                    } else if (tokens[1].equals("Truck")) {
                        truck.refuel(liters);
                    }
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
