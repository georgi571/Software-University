package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces;


import jdk.jshell.spi.ExecutionControl;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException;
}