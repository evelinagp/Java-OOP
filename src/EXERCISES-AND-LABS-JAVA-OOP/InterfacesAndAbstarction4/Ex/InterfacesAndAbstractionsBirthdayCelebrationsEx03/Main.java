package InterfacesAndAbstarction4.Ex.InterfacesAndAbstractionsBirthdayCelebrationsEx03;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Class[] citizenInterfaces = Citizen.class.getInterfaces();
        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
            Method[] methods = Birthable.class.getDeclaredMethods();
            // methods = Identifiable.class.getDeclaredMethods();
            Scanner scanner = new Scanner(System.in);
            List<Birthable> birthables = new ArrayList<>();
            String input = scanner.nextLine();
            while (!input.equals("End")) {
                String[] tokens = input.split("\\s+");
                if (tokens.length == 5) {
                    String type = tokens[0];
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthDate = tokens[4];
                    Identifiable identifiable = new Citizen(name, age, id, birthDate);
                    Birthable birthable = new Citizen(name, age, id, birthDate);
                    birthables.add(birthable);
                } else if (tokens.length == 3) {
                    if (tokens[0].equals("Pet")) {
                        String name = tokens[1];
                        String birthDate = tokens[2];
                        Birthable birthable = new Pet(name, birthDate);
                        birthables.add(birthable);
                    } else if (tokens[0].equals("Robot")) {
                        String model = tokens[1];
                        String id = tokens[2];
                        Identifiable identifiable = new Robot(model, id);
                    }
                }
                input = scanner.nextLine();
            }
            String postFix = scanner.nextLine();
            for (Birthable birthable : birthables) {
                if (birthable.getBirthDate().endsWith(postFix)) {
                    System.out.println(birthable.getBirthDate());
                }else{
                    System.out.println("No valid output!");
                }
            }
//            System.out.println(methods.length);
//            System.out.println(methods[0].getReturnType().getSimpleName());
//            System.out.println(methods.length);
//            System.out.println(methods[0].getReturnType().getSimpleName());
        }
    }
}
