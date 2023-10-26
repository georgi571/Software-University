package _1ProgrammingBasicsWithJavaMay2023._8Exam._1MainExam;

import java.util.Scanner;

public class _01ChristmasPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rollOfPaper = Integer.parseInt(scanner.nextLine());
        int rollOfFabric = Integer.parseInt(scanner.nextLine());
        double litersOfGlue = Double.parseDouble(scanner.nextLine());
        int percentDiscount = Integer.parseInt(scanner.nextLine());
        double priceForPaper = rollOfPaper * 5.80;
        double priceForFabric = rollOfFabric * 7.20;
        double priceForGlue = litersOfGlue * 1.20;
        double totalSum = priceForGlue + priceForFabric + priceForPaper;
        double sumAfterDiscount = totalSum * ((100 - percentDiscount) / 100.00);
        System.out.printf("%.3f", sumAfterDiscount);
    }
}
