package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._1BasicSyntaxConditionalStatementsAndLoops._2Exercise;

import java.util.Scanner;

public class _03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String groupOfPeople = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double priceForGroup = 0.0;
        if (groupOfPeople.equals("Students")) {
            if (dayOfWeek.equals("Friday")) {
                priceForGroup = numberOfPeople * 8.45;
            } else if (dayOfWeek.equals("Saturday")) {
                priceForGroup = numberOfPeople * 9.80;
            } else if (dayOfWeek.equals("Sunday")) {
                priceForGroup = numberOfPeople * 10.46;
            }
            if (numberOfPeople >= 30) {
                priceForGroup = priceForGroup * 0.85;
            }
        } else if (groupOfPeople.equals("Business")) {
            if (numberOfPeople >= 100) {
                numberOfPeople = numberOfPeople - 10;
            }
            if (dayOfWeek.equals("Friday")) {
                priceForGroup = numberOfPeople * 10.90;
            } else if (dayOfWeek.equals("Saturday")) {
                priceForGroup = numberOfPeople * 15.60;
            } else if (dayOfWeek.equals("Sunday")) {
                priceForGroup = numberOfPeople * 16.00;
            }
        } else if (groupOfPeople.equals("Regular")) {
            if (dayOfWeek.equals("Friday")) {
                priceForGroup = numberOfPeople * 15.00;
            } else if (dayOfWeek.equals("Saturday")) {
                priceForGroup = numberOfPeople * 20.00;
            } else if (dayOfWeek.equals("Sunday")) {
                priceForGroup = numberOfPeople * 22.50;
            }
            if (numberOfPeople >= 10 && numberOfPeople <= 20) {
                priceForGroup = priceForGroup * 0.95;
            }
        }
        System.out.printf("Total price: %.2f", priceForGroup);
    }
}
