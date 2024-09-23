package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._3MoreExercise;

import java.util.Scanner;

public class _08FuelTankPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOfPetrol = scanner.nextLine();
        double liters = Double.parseDouble(scanner.nextLine());
        String clubCard = scanner.nextLine();
        double priceOfGasoline = 2.22;
        double priceOfDiesel = 2.33;
        double priceOfGas = 0.93;
        if (clubCard.equals("Yes")) {
            priceOfGasoline = priceOfGasoline - 0.18;
            priceOfDiesel = priceOfDiesel - 0.12;
            priceOfGas = priceOfGas - 0.08;
        }
        if (typeOfPetrol.equals("Gasoline")) {
            double totalPriceForGasoline = liters * priceOfGasoline;
            if (liters >= 20 && liters <= 25) {
                double taxForGasoline = totalPriceForGasoline * 0.08;
                double priceAfterTaxGasoline = totalPriceForGasoline - taxForGasoline;
                System.out.printf("%.2f lv.", priceAfterTaxGasoline);
            } else if (liters > 25) {
                double taxForGasoline = totalPriceForGasoline * 0.10;
                double priceAfterTaxGasoline = totalPriceForGasoline - taxForGasoline;
                System.out.printf("%.2f lv.", priceAfterTaxGasoline);
            } else {
                System.out.printf("%.2f lv.", totalPriceForGasoline);
            }
        } else if (typeOfPetrol.equals("Diesel")) {
            double totalPriceForDiesel = liters * priceOfDiesel;
            if (liters >= 20 && liters <= 25) {
                double taxForDiesel = totalPriceForDiesel * 0.08;
                double priceAfterTaxDiesel = totalPriceForDiesel - taxForDiesel;
                System.out.printf("%.2f lv.", priceAfterTaxDiesel);
            } else if (liters > 25) {
                double taxForDiesel = totalPriceForDiesel * 0.10;
                double priceAfterTaxDiesel = totalPriceForDiesel - taxForDiesel;
                System.out.printf("%.2f lv.", priceAfterTaxDiesel);
            } else {
                System.out.printf("%.2f lv.", totalPriceForDiesel);
            }
        } else if (typeOfPetrol.equals("Gas")) {
            double totalPriceForGas = liters * priceOfGas;
            if (liters >= 20 && liters <= 25) {
                double taxForGas = totalPriceForGas * 0.08;
                double priceAfterTaxGas = totalPriceForGas - taxForGas;
                System.out.printf("%.2f lv.", priceAfterTaxGas);
            } else if (liters > 25) {
                double taxForGas = totalPriceForGas * 0.10;
                double priceAfterTaxGas = totalPriceForGas - taxForGas;
                System.out.printf("%.2f lv.", priceAfterTaxGas);
            } else {
                System.out.printf("%.2f lv.", totalPriceForGas);
            }
        }
    }
}
