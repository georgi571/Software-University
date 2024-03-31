package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double OXYGEN = 70;
    private static final double DECREASE_OXYGEN = 5;
    public Biologist(String name) {
        super(name, OXYGEN);
    }

    @Override
    public void breath() {
        if (super.getOxygen() >= 5) {
            super.setOxygen(super.getOxygen() - DECREASE_OXYGEN);
        } else {
            super.setOxygen(0);
        }
    }
}
