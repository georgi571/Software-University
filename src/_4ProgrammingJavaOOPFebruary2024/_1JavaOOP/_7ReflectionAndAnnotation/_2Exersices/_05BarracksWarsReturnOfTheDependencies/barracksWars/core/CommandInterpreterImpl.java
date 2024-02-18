package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._05BarracksWarsReturnOfTheDependencies.barracksWars.core;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMAND_PATH = "_4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._05BarracksWarsReturnOfTheDependencies.barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data) {
        Executable command = null;
        String commandName = Character.toUpperCase(data[0].charAt(0)) + data[0].substring(1);
        try {
            Class<?> clazz = Class.forName(COMMAND_PATH + commandName);
            Constructor<?> constructor = clazz.getDeclaredConstructor(String[].class);
            command = (Executable) constructor.newInstance(new Object[]{data});
            Field[] fields = command.getClass().getDeclaredFields();
            Field[] localFields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Inject.class)) {
                    for (Field localField : localFields) {
                        if (field.getType().equals(localField.getType())) {
                            field.setAccessible(true);
                            field.set(command, localField.get(this));
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return command;
    }
}
