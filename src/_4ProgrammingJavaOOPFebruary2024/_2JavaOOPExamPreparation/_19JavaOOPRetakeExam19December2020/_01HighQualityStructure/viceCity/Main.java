package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.core.EngineImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.core.interfaces.Controller;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = null; // TODO
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
