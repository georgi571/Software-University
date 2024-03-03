package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._01HighQualityStructure.aquarium.entities.fish;

public class SaltwaterFish extends BaseFish {
    private static final int SIZE = 5;
    private static final int INCREASE_SIZE = 2;
    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(SIZE);
    }

    @Override
    public void eat() {
        super.setSize(super.getSize() + INCREASE_SIZE);
    }
}
