package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._01HighQualityStructure.onlineShop.models.products.computers;

public class Laptop extends BaseComputer {
    private static final double PERFORMANCE = 10;
    public Laptop(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, PERFORMANCE);
    }
}
