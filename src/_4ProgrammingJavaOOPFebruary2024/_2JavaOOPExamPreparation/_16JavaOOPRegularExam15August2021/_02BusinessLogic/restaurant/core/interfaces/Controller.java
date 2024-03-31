package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._02BusinessLogic.restaurant.core.interfaces;

public interface Controller {
    String addHealthyFood(String type, double price, String name);

    String addBeverage(String type, int counter, String brand, String name);

    String addTable(String type, int number, int size);

    String reserve(int numberOfPeople);

    String orderHealthyFood(int tableNumber, String healthyFoodName);

    String orderBeverage(int tableNumber, String name, String brand);

    String closedBill(int tableNumber);

    String totalMoney();
}
