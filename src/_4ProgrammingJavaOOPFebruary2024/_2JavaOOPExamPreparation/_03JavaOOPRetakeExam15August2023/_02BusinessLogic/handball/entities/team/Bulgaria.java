package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.entities.team;

public class Bulgaria extends BaseTeam {
    private static final int ADVANTAGE = 115;
    public Bulgaria(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
        int advantage = super.getAdvantage() + ADVANTAGE;
        super.setAdvantage(advantage);
    }
}
