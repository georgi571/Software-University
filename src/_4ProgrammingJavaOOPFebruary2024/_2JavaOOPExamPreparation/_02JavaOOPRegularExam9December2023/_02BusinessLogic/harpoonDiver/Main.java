package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.core.Controller;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.core.ControllerImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.core.Engine;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
