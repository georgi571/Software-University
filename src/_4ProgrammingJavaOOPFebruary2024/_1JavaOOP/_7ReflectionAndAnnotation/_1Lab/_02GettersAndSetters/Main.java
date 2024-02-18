package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._1Lab._02GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class reflections = Reflection.class;
        Method[] methods = reflections.getDeclaredMethods();
        sortMethods(methods);
        for (Method method : methods) {
            if (method.getName().startsWith("get") & method.getParameterCount() == 0) {
                System.out.printf("%s will return class %s%n", method.getName(), method.getReturnType().getTypeName());
            }
        }
        for (Method method : methods) {
            if (method.getName().startsWith("set") & method.getParameterCount() == 1) {
                System.out.printf("%s and will set field of class %s%n", method.getName(), method.getParameterTypes()[0].getTypeName());
            }
        }
    }

    private static void sortMethods(Method[] methods) {
        Arrays.sort(methods, Comparator.comparing(Method::getName));
    }
}
