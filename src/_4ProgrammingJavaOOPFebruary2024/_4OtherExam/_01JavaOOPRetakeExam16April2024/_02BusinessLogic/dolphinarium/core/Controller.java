package _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.core;

//TODO Implement all methods

public interface Controller {
    String addPool(String poolType, String poolName);
    String buyFood(String foodType);
    String addFoodToPool(String poolName, String foodType);
    String addDolphin(String poolName, String dolphinType, String dolphinName, int energy);
    String feedDolphins(String poolName, String food);
    String playWithDolphins(String poolName);
    String getStatistics();
}
