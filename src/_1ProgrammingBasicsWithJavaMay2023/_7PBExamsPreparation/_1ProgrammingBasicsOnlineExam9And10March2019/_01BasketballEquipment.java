package _1ProgrammingBasicsWithJavaMay2023._7PBExamsPreparation._1ProgrammingBasicsOnlineExam9And10March2019;

import java.util.Scanner;

public class _01BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int yearTax = Integer.parseInt(scanner.nextLine());
        double shoes = yearTax * 0.60;
        double clothes = shoes * 0.80;
        double balls = clothes * 1/4;
        double accsesories = balls * 1/5;
        double totalSum = yearTax + shoes + clothes + balls + accsesories;
        System.out.printf("%.2f", totalSum);
    }
}
