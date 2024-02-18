package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._04BarracksWarsTheCommandsStrikeBack.barracksWars.models.units;

public class Gunner extends AbstractUnit {
    private static final int GUNNER_HEALTH = 20;
    private static final int GUNNER_DAMAGE = 20;
    public Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
}