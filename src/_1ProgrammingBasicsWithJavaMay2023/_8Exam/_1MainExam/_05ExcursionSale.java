package _1ProgrammingBasicsWithJavaMay2023._8Exam._1MainExam;

import java.util.Scanner;

public class _05ExcursionSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int excursionSea = Integer.parseInt(scanner.nextLine());
        int excursionMountain = Integer.parseInt(scanner.nextLine());
        int seaNew = excursionSea;
        int mountainNew = excursionMountain;
        int profit = 0;
        boolean isSold = false;
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String nameOfPackage = command;
            if (nameOfPackage.equals("sea")) {
                if (seaNew > 0) {
                    profit += 680;
                } else {
                    profit += 0;
                }
                seaNew--;
            } else if (nameOfPackage.equals("mountain")) {
                if (mountainNew > 0) {
                    profit += 499;
                } else {
                    profit += 0;
                }
                mountainNew--;
            }
            if (mountainNew <=0 && seaNew <= 0) {
                break;
            }
            command = scanner.nextLine();
        }
        if (mountainNew <= 0 && seaNew <= 0) {
            System.out.printf("Good job! Everything is sold.%n");
        }
        System.out.printf("Profit: %d leva.", profit);
    }
}