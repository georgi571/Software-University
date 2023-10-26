package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._1BasicSyntaxConditionalStatementsAndLoops._2Exercise;

import java.util.Scanner;

public class _10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        double priceForLightsaber = Double.parseDouble(scanner.nextLine());
        double priceForRobe = Double.parseDouble(scanner.nextLine());
        double priceForBelt = Double.parseDouble(scanner.nextLine());
        double numberOfBlades = Math.ceil(numberOfStudents * 1.10);
        double saberCost = numberOfBlades * priceForLightsaber;
        double numberOfBelts = numberOfStudents - (numberOfStudents / 6);
        double beltsCost = numberOfBelts * priceForBelt;
        double robeCost = numberOfStudents * priceForRobe;
        double totalPrice = saberCost + beltsCost + robeCost;
        double diff = totalPrice - budget;
        if (budget >= totalPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.",totalPrice);
        } else if (budget < totalPrice) {
            System.out.printf("George Lucas will need %.2flv more.", diff);
        }
    }
}
