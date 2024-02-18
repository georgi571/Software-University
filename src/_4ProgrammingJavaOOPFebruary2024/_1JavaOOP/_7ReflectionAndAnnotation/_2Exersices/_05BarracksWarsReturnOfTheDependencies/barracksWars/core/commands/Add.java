package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._05BarracksWarsReturnOfTheDependencies.barracksWars.core.commands;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.Inject;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.Repository;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.Unit;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.UnitFactory;

public class Add extends Command {
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;
    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
