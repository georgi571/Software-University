package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._02BlackBoxInteger.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        Field innerValue = clazz.getDeclaredField("innerValue");
        List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commandParts = command.split("_");
            String commandName = commandParts[0];
            int number = Integer.parseInt(commandParts[1]);
            Method method = null;
            for (Method currentMethod : methods) {
                if (currentMethod.getName().equals(commandName)) {
                    method = currentMethod;
                    break;
                }
            }
            method.setAccessible(true);
            method.invoke(blackBoxInt, number);
            innerValue.setAccessible(true);
            System.out.printf("%d%n",innerValue.get(blackBoxInt));
            command = scanner.nextLine();
        }
    }
}
