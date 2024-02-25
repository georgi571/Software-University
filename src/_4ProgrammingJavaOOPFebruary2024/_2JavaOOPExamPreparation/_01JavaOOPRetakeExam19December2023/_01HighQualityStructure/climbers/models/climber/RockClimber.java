package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._01HighQualityStructure.climbers.models.climber;

public class RockClimber extends BaseClimber{
    private static final int STRENGTH = 120;
    private static final int DECREASE_STRENGTH = 60;
    public RockClimber(String name) {
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
