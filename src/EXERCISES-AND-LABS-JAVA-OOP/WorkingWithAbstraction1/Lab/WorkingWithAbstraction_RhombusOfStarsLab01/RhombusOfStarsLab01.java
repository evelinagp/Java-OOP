package WorkingWithAbstraction1.Lab.WorkingWithAbstraction_RhombusOfStarsLab01;

import java.util.Scanner;

public class RhombusOfStarsLab01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
//First half
        for (int r = 1; r <= n; r++) {
            for (int i = 0; i < n - r; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < r; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
//        Second half
        for (int r = 1; r <= n - 1; r++) {
            for (int i = 0; i < r; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < n - r; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
