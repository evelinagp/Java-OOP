package Reflection_blackBoxIntegerEx02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchFieldException {
//       обект от класа
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        List<Method> methods =Arrays.asList(clazz.getDeclaredMethods());
        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("_");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);
//            търся и намирам кой е метода от списъка
            Method currentMethod = getCurrentMethod ( methods, command);
//            Method currentMethod = methods.stream().filter(metod -> metod.getName().equals(command))
//                    .findFirst().orElse(null);
//            изпълнявам метода
            currentMethod.setAccessible(true);
            currentMethod.invoke(blackBoxInt, value);
            System.out.println(innerValue.get(blackBoxInt));
            input = scanner.nextLine();
        }
    }

    private static Method getCurrentMethod(List<Method> methods, String command) {
        for (Method method : methods) {
            if (method.getName().equals(command)){
                return method;
            }
        }
        return null;
    }
}
