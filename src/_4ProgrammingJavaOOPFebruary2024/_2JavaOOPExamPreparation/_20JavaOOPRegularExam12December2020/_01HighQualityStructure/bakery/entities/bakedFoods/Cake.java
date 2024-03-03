package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.entities.bakedFoods;

public class Cake extends BaseFood{
    private static final double PORTION = 200;
    public Cake(String name, double price) {
        super(name, PORTION, price);
    }
}
