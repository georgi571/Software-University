package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.entities.supplements;

public abstract class BaseSupplement implements Supplement{
    private int hardness;
    private double price;

    public BaseSupplement(int hardness, double price) {
        this.hardness = hardness;
        this.price = price;
    }

    @Override
    public int getHardness() {
        return this.hardness;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
