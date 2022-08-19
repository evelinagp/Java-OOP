package InheritancePlayersAndMonstersEx03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int level = Integer.parseInt(scanner.nextLine());

        BladeKnight bladeKnight = new BladeKnight(name, level);

        System.out.println(bladeKnight.toString());
    }
}
