package _1ProgrammingBasicsWithJavaMay2023._5WhileLoop._3MoreExercise;

import java.util.Scanner;

public class _02ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int expectedSum = Integer.parseInt(scanner.nextLine());
        int countCash = 0;
        int countCard = 0;
        int currentPay = 0;
        double sumForCash = 0;
        double sumForCard = 0;
        boolean isMoneyEnough = false;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            currentPay++;
            int currentPayment = Integer.parseInt(command);
            if (currentPay % 2 == 0) {
                if (currentPayment < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    countCard++;
                    sumForCard += currentPayment;
                    System.out.println("Product sold!");
                }
            } else {// за плащания кеш
                if (currentPayment > 100) {
                    System.out.println("Error in transaction!");
                } else {
                    countCash++;
                    sumForCash += currentPayment;
                    System.out.println("Product sold!");
                }
            }
            if ((sumForCash + sumForCard) >= expectedSum) {
                isMoneyEnough = true;
                break;
            }
            command = scanner.nextLine();
        }
        if (isMoneyEnough) {
            double avaragePayInCash = sumForCash / countCash;
            double avaragePayByCard = sumForCard / countCard;
            System.out.printf("Average CS: %.2f%n",avaragePayInCash);
            System.out.printf("Average CC: %.2f%n",avaragePayByCard);
        } else {
            System.out.printf("Failed to collect required money for charity.%n");
        }
    }
}
