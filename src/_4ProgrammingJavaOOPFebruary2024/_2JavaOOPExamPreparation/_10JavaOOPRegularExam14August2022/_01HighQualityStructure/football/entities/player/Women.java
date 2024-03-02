package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._01HighQualityStructure.football.entities.player;


public class Women extends BasePlayer {
    private static final double KILOGRAMS = 60.00;
    private static final int INCREASE_STRENGTH = 115;
    public Women(String name, String nationality, int strength) {
        super(name, nationality,KILOGRAMS ,strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + INCREASE_STRENGTH);
    }
}
