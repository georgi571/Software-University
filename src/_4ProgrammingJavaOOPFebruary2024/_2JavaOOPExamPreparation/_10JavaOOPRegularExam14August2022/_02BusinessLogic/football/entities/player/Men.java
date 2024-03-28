package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.player;

public class Men extends BasePlayer {
    private static final double KILOGRAMS = 85.50;
    private static final int INCREASE_STRENGTH = 145;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, KILOGRAMS, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + INCREASE_STRENGTH);
    }
}
