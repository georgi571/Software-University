package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._3MoreExercise;

import java.util.Scanner;

public class _06FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfMagnolias = Integer.parseInt(scanner.nextLine());
        int numberOfHyacinths = Integer.parseInt(scanner.nextLine());
        int numberOfRoses = Integer.parseInt(scanner.nextLine());
        int numberOfCacti = Integer.parseInt(scanner.nextLine());
        double priceOfGift = Double.parseDouble(scanner.nextLine());
        double priceOfMagnolias = numberOfMagnolias * 3.25;
        double priceOfHyacinths = numberOfHyacinths * 4.00;
        double priceOfRoses = numberOfRoses * 3.50;
        double priceOfCacti = numberOfCacti * 8.00;
        double priceOfFlowers = priceOfMagnolias + priceOfHyacinths + priceOfRoses + priceOfCacti;
        double taxes = priceOfFlowers * 0.05;
        double netMoney = priceOfFlowers - taxes;
        double diff = Math.abs(netMoney-priceOfGift);
        if (netMoney < priceOfGift) {
            double moneyNeed = Math.ceil(diff);
            System.out.printf("She will have to borrow %.0f leva.", moneyNeed);
        } else {
            double moneyLeft = Math.floor(diff);
            System.out.printf("She is left with %.0f leva.", moneyLeft);
        }
    }
}
