package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._01HighQualityStructure.harpoonDiver;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._01HighQualityStructure.harpoonDiver.core.Controller;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._01HighQualityStructure.harpoonDiver.core.Engine;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._01HighQualityStructure.harpoonDiver.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = null; //TODO new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
