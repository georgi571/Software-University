package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._02BusinessLogic.christmasPastryShop.entities.booths;

public class OpenBooth extends BaseBooth {
    private static final double PRICE_PER_PERSON = 2.50;

    public OpenBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, PRICE_PER_PERSON);
    }
}
