package _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.dolphins;

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
