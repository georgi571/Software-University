package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.models.products.computers;

public class DesktopComputer extends BaseComputer{
    private final static double INITIAL_PERFORMANCE = 15;
    public DesktopComputer(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, INITIAL_PERFORMANCE);
    }
}
