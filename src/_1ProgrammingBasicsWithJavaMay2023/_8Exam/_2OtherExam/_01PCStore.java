package _1ProgrammingBasicsWithJavaMay2023._8Exam._2OtherExam;

import java.util.Scanner;

public class _01PCStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceOfProcessor = Double.parseDouble(scanner.nextLine());
        double priceOfVideoCard = Double.parseDouble(scanner.nextLine());
        double priceOfRamMemory = Double.parseDouble(scanner.nextLine());
        int numberOfRamMemory = Integer.parseInt(scanner.nextLine());
        double percentOfDiscount = Double.parseDouble(scanner.nextLine());
        double totalPrice = ((priceOfProcessor + priceOfVideoCard) - percentOfDiscount * (priceOfProcessor + priceOfVideoCard) + (priceOfRamMemory * numberOfRamMemory));
        double priceInBGN = totalPrice * 1.57;
        System.out.printf("Money needed - %.2f leva.", priceInBGN);
    }
}