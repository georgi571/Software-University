package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021._01HighQualityStructure.christmasRaces.entities.cars;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021._01HighQualityStructure.christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar{
    private static final double CUBIC_CENTIMETERS = 3000;
    public SportsCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower < 250 || horsePower > 450) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        this.setHorsePower(horsePower);
    }
}
