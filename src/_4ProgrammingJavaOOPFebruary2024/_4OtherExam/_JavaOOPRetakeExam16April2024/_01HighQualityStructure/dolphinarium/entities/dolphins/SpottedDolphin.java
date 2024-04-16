package _4ProgrammingJavaOOPFebruary2024._4OtherExam._JavaOOPRetakeExam16April2024._01HighQualityStructure.dolphinarium.entities.dolphins;

public class SpottedDolphin extends BaseDolphin{
    public SpottedDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        super.jump();
        super.setEnergy(super.getEnergy() - 90);
    }
}
