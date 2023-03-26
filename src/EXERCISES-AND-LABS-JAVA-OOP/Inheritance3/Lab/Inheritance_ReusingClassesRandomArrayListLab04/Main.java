package Inheritance3.Lab.Inheritance_ReusingClassesRandomArrayListLab04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RandomArrayList<Integer> list = new RandomArrayList<>();
        list.add(12);
        list.add(-12);
        list.add(112);
        list.add(42);
        System.out.println(list.getRandomElement());
        System.out.println(list.removeRandomElement());
        System.out.println(list);

    }
}
