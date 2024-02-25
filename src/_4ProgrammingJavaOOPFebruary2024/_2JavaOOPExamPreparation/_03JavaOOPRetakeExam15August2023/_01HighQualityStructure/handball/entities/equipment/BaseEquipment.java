package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._01HighQualityStructure.handball.entities.equipment;

public class BaseEquipment implements Equipment{
    private int protection;
    private double price;

    public BaseEquipment(int protection, double price) {
        this.protection = protection;
        this.price = price;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
