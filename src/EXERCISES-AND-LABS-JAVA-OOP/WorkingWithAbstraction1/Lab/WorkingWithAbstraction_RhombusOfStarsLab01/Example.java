package WorkingWithAbstraction1.Lab.WorkingWithAbstraction_RhombusOfStarsLab01;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println(DayOfWeekExample.SUNDAY.ordinal());
        DayOfWeekExample [] values = DayOfWeekExample.values();
        for (DayOfWeekExample value : values) {
            System.out.println(value);
        }
    }
}
