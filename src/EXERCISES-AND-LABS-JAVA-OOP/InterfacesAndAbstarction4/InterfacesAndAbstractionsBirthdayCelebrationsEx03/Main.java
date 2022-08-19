package InterfacesAndAbstractionsBirthdayCelebrationsEx03;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Class[] citizenInterfaces = Citizen.class.getInterfaces();
        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
            Method[] methods = Birthable.class.getDeclaredMethods();
            methods = Identifiable.class.getDeclaredMethods();
            Scanner scanner = new Scanner(System.in);
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
                }else if (tokens.length == 3){
                    if(tokens[0].equals("Pet")){
                        String name = tokens[1];
                        String birthDate = tokens[2];
                        Birthable birthable = new Pet(name, birthDate);
                    }else if (tokens[0].equals("Robot")){
                        String model = tokens[1];
                        String id = tokens[2];
                        Identifiable identifiable = new Robot(model,id);
                    }
                }
            input = scanner.nextLine();
            }
            int year = Integer.parseInt(scanner.nextLine());
            for (Method method : methods) {
                if (method.equals(year)){
                    System.out.println(method);
                }
            }
//            System.out.println(methods.length);
//            System.out.println(methods[0].getReturnType().getSimpleName());
//            System.out.println(methods.length);
//            System.out.println(methods[0].getReturnType().getSimpleName());
        }
    }
}
