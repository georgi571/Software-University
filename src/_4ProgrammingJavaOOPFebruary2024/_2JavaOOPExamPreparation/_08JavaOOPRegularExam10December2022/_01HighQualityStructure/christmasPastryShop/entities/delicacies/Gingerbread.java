package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.entities.delicacies;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.entities.delicacies.BaseDelicacy;

public class Gingerbread extends BaseDelicacy {
    private static final double PORTION = 200;

    public Gingerbread(String name, double price) {
        super(name, PORTION, price);
    }
}
