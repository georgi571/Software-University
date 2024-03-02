package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._01HighQualityStructure.catHouse.entities.cat;

public class LonghairCat extends BaseCat {
    private static final int KILOGRAMS = 9;
    private static final int INCREASE_KILOGRAMS = 3;
    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(KILOGRAMS);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + INCREASE_KILOGRAMS);
    }
}
