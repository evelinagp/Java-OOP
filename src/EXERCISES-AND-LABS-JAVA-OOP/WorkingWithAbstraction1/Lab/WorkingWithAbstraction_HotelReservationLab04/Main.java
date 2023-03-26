package WorkingWithAbstraction1.Lab.WorkingWithAbstraction_HotelReservationLab04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(tokens[0]);
        int numberOfDays = Integer.parseInt(tokens[1]);
        String inputSeason = tokens[2];
        String discountType = tokens[3];

        Season season = Season.valueOf(inputSeason.toUpperCase());

        PriceCalculator priceCalculator = new PriceCalculator(season, DiscountType.valueOf(discountType.toUpperCase()), pricePerDay, numberOfDays);

        System.out.println(priceCalculator.calculatePrice());
    }
}
