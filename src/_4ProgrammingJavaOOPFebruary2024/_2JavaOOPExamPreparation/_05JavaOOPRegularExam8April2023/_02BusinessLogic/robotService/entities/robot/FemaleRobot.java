package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.entities.robot;

public class FemaleRobot extends BaseRobot {
    private static final int KILOGRAMS = 7;
    private static final int INCREASE_KILOGRAMS = 1;

    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, KILOGRAMS, price);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + INCREASE_KILOGRAMS);
    }
}
