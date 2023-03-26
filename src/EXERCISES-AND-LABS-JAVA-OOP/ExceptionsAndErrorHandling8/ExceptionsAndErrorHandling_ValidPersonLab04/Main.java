package ExceptionsAndErrorHandling8.ExceptionsAndErrorHandling_ValidPersonLab04;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fName = scanner.nextLine();
        String lName = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        try {
            Person p = createPerson(fName, lName, age);
             System.out.println(p);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Person createPerson(String firstName, String lastName, int age) {
        return new Person(firstName, lastName, age);
    }
}
