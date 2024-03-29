package WorkingWithAbstraction1.Lab.WorkingWithAbstraction_PointInRectangleLab02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        Point2D bottomLeftPoint = new Point2D(coordinates[0], coordinates[1]);
        Point2D topRightPoint = new Point2D(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(bottomLeftPoint, topRightPoint);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            boolean contains = rectangle.contains(new Point2D(coordinates[0], coordinates[1]));

            System.out.println(contains);

        }
    }
}
