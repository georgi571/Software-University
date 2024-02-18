package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._04BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;

public class Fight extends Command {
    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
