import java.util.Scanner;

public class WorkingWithAbstraction_RhombusOfStarsLab01WithMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printTop(n);
        printBottom(n - 1);

    }

    public static void printBottom(int count) {
        for (int i = 1; i <= count; i++) {
            printStringNumberOfTimes(i, " ");
            printStringNumberOfTimes(count - (i - 1), "* ");
            System.out.println();
        }
    }

    private static void printStringNumberOfTimes(int count, String s) {
        for (int i = 0; i < count; i++) {
            System.out.print(s);
        }
    }

    private static void printTop(int rowsCount) {
        for (int i = 1; i <= rowsCount; i++) {
            printStringNumberOfTimes(rowsCount - i, " ");
            printStringNumberOfTimes(i, "* ");
            System.out.println();
        }
    }
}
