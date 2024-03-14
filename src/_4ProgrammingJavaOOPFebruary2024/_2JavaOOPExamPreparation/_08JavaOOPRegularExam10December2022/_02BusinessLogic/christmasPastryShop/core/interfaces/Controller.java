package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._02BusinessLogic.christmasPastryShop.core.interfaces;

public interface Controller {
   String addDelicacy(String type, String name, double price);

   String addCocktail(String type, String name, int portion, String brand);

   String addBooth(String type, int tableNumber, int capacity);

   String reserveBooth(int numberOfPeople);

   String leaveBooth(int tableNumber);

   String getIncome();
}
