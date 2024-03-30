package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.models.products.components;

public class VideoCard extends BaseComponent {
    private final static double INITIAL_MULTIPLIER = 1.15;

    public VideoCard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance, generation);
        super.setOverallPerformance(overallPerformance * INITIAL_MULTIPLIER);
    }
}
