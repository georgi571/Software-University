package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.climber;

public class WallClimber extends BaseClimber {
    private static final int STRENGTH = 90;
    private static final int DECREASE_STRENGTH = 30;

    public WallClimber(String name) {
        super(name, STRENGTH);
    }

    @Override
    public void climb() {
        double newStrength = super.getStrength();
        newStrength -= DECREASE_STRENGTH;
        if (newStrength < 0) {
            newStrength = 0;
        }
        super.setStrength(newStrength);
    }
}
