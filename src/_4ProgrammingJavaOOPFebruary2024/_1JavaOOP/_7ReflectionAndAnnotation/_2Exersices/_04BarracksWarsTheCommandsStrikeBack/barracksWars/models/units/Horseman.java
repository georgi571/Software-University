package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._04BarracksWarsTheCommandsStrikeBack.barracksWars.models.units;

public class Horseman extends AbstractUnit {
    private static final int HORSEMAN_HEALTH = 50;
    private static final int HORSEMAN_DAMAGE = 10;
    public Horseman() {
        super(HORSEMAN_HEALTH, HORSEMAN_DAMAGE);
    }
}