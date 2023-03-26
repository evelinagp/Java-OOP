package ReflectionAndAnnotation7.Lab.ReflectionAndAnnotation_ReflectionLab01;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?>clazz = Class.forName("ReflectionAndAnnotation7.Lab.ReflectionAndAnnotation_ReflectionLab01.Reflection");
        System.out.println("class " + clazz.getSimpleName());
        System.out.println("class " + clazz.getSuperclass().getName());
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("interface " + anInterface.getName());

//            Object reflectionObject = clazz.getDeclaredConstructor().newInstance();
            Reflection reflectionObject = (Reflection) clazz.getDeclaredConstructor().newInstance();
            System.out.println(reflectionObject);
        }
    }
}
