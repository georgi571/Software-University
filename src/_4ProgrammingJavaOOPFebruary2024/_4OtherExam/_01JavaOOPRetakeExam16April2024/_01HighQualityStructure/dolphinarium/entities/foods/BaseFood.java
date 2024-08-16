package _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._01HighQualityStructure.dolphinarium.entities.foods;

public abstract class BaseFood implements Food{
    private int calories;

    public BaseFood(int calories) {
        this.calories = calories;
    }

    @Override
    public int getCalories() {
        return this.calories;
    }
}
