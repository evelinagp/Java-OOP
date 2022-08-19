package Reflection_harvestingFieldsEx01;

import Reflection_harvestingFieldsEx01.RichSoilLand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();


        List<Field> fields = Arrays.asList(RichSoilLand.class.getDeclaredFields());
        Map<Commands, List<Field>> modifiersFieldsMap = getMap(fields);
//access modifier - списък с полета
        fillMapWithFields(fields, modifiersFieldsMap);
        Consumer<Field> printer = field -> System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName()
                + " " + field.getName());
        while (!"HARVEST".equals(input)) {
            switch (input) {
                case "private":
                    modifiersFieldsMap.get(Commands.PRIVATE).forEach(field -> printer.accept(field));
                    break;
                case "protected":
                    modifiersFieldsMap.get(Commands.PROTECTED).forEach(field -> printer.accept(field));
                    break;
                case "public":
                    modifiersFieldsMap.get(Commands.PUBLIC).forEach(field -> printer.accept(field));
                    break;
                case "all":
                    modifiersFieldsMap.get(Commands.ALL).forEach(field -> printer.accept(field));
                    break;
            }
            input = reader.readLine();
        }
    }

    private static Map<Commands, List<Field>> getMap(List<Field> fields) {
        Map<Commands, List<Field>> modifiersFieldsMap = new LinkedHashMap<>();
        modifiersFieldsMap.put(Commands.PUBLIC, new ArrayList<>());
        modifiersFieldsMap.put(Commands.PRIVATE, new ArrayList<>());
        modifiersFieldsMap.put(Commands.PROTECTED, new ArrayList<>());
        modifiersFieldsMap.put(Commands.ALL, fields);
        return modifiersFieldsMap;
    }

    private static void fillMapWithFields(List<Field> fields, Map<Commands, List<Field>> modifiersFieldsMap) {
        for (Field field : fields) {
            String modifier = Modifier.toString(field.getModifiers());
            switch (modifier) {
                case "public":
                    modifiersFieldsMap.get(Commands.PUBLIC).add(field);
                    break;
                case "private":
                    modifiersFieldsMap.get(Commands.PRIVATE).add(field);
                    break;
                case "protected":
                    modifiersFieldsMap.get(Commands.PROTECTED).add(field);
                    break;
            }

        }
    }
}
