package WorkingWithAbstraction1.Ex.WorkingWithAbstraction_CardRankEx02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("Card Ranks")) {
            System.out.println("Card Ranks:");
            for (CardRank rank : CardRank.values()) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(), rank);
            }
        }
    }
}
