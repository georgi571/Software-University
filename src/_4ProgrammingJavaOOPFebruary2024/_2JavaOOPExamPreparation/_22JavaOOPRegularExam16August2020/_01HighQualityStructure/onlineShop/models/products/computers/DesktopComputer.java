package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._01HighQualityStructure.onlineShop.models.products.computers;

public class DesktopComputer extends BaseComputer{
    private static final double PERFORMANCE = 15;

    public DesktopComputer(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, PERFORMANCE);
    }
}
