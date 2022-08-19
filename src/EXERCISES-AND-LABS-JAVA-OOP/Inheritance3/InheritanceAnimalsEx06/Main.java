package InheritanceAnimalsEx06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();
        String typeAnimal = "";
        while (!"Beast!".equals(typeAnimal = scanner.nextLine())) {
            String[] animalData = scanner.nextLine().split("\\s+");
            String name = animalData[0];
            int age = Integer.parseInt(animalData[1]);
            String gender = animalData[2];
            Animal animal = null;
            try {

                switch (typeAnimal) {
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                        break;
                    case "Kitten":
                        animal = new Kitten(name, age);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name, age);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if (animal != null) {
                animals.add(animal);
            }
            //            typeAnimal = scanner.nextLine();
        }
        animals.forEach(e -> System.out.println(e));
    }
}

