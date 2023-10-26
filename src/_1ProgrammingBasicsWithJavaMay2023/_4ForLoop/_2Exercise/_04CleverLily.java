package _1ProgrammingBasicsWithJavaMay2023._4ForLoop._2Exercise;

import java.util.Scanner;

public class _04CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        double priceOfWashingMachine = Double.parseDouble(scanner.nextLine());
        int sellingPriceOfToy = Integer.parseInt(scanner.nextLine());
        int savedMoney = 0;
        int currentMoney = 10;
        int toy = 0;
        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                savedMoney += currentMoney;
                currentMoney += 10;
                savedMoney -= 1;
            } else {
                toy += 1;
            }
        }
        int moneyFromToys = toy * sellingPriceOfToy;
        int totalSum = moneyFromToys + savedMoney;
        double diff = Math.abs(totalSum - priceOfWashingMachine);
        if (totalSum >= priceOfWashingMachine) {
            System.out.printf("Yes! %.2f", diff);
        } else {
            System.out.printf("No! %.2f", diff);
        }
    }
}
