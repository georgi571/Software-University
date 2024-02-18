package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._05BarracksWarsReturnOfTheDependencies.barracksWars.core.commands;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.Inject;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.Repository;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.UnitFactory;

public class Report extends Command {
    @Inject
    private Repository repository;
    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
