package _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant;

import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.core.Controller;
import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.core.ControllerImpl;
import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.core.Engine;
import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
