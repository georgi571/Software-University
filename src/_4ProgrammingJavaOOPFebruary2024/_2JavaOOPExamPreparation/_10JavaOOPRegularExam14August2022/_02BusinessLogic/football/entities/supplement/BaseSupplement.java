package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.supplement;

public class BaseSupplement implements Supplement {
    private int energy;
    private double price;

    public BaseSupplement(int energy, double price) {
        this.energy = energy;
        this.price = price;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
