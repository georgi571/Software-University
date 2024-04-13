package _1ProgrammingBasicsWithJavaMay2023._7PBExamsPreparation._ProgrammingBasicsOnlineExampleExam4;

import java.util.Scanner;

public class _04Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int leftSeats = capacity;
        int totalIncome = 0;
        while (!command.equals("Movie time!")) {
            int currentNumberOfPeople = Integer.parseInt(command);
            if (leftSeats < currentNumberOfPeople) {
                break;
            }
            int currentIncome = currentNumberOfPeople * 5;
            if (currentNumberOfPeople % 3 == 0) {
                currentIncome -= 5;
            }
            totalIncome += currentIncome;
            leftSeats -= currentNumberOfPeople;
            command = scanner.nextLine();
        }
        if (command.equals("Movie time!")) {
            System.out.printf("There are %d seats left in the cinema.%n", leftSeats);
        } else {
            System.out.printf("The cinema is full.%n");
        }
        System.out.printf("Cinema income - %d lv.",totalIncome);
    }
}
