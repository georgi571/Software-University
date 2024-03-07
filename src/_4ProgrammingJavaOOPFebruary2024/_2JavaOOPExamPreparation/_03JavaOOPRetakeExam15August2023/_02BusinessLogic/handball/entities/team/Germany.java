package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.entities.team;

public class Germany extends BaseTeam {
    private static final int ADVANTAGE = 145;
    public Germany(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
        int advantage = super.getAdvantage() + ADVANTAGE;
        setAdvantage(advantage);
    }
}
