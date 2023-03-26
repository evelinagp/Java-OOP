package Solid6.SolidLab.p05_DependencyInversion.p01_HelloWord;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(helloWorld.greeting(name));
        //     System.out.println("Hello World");
    }
}
