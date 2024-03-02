package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._01HighQualityStructure.zoo.entities.foods;

public abstract class BaseFood implements Food {
    private int calories;
    private double price;

    public BaseFood(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }

    @Override
    public int getCalories() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
