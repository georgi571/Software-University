package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {

    private static final double KILOGRAMS = 5.50;
    private static final double INCREASE_KILOGRAMS = 5.70;

    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, KILOGRAMS, price);
    }

    @Override
    public void eat() {
        super.setKg(super.getKg() + INCREASE_KILOGRAMS);
    }
}
