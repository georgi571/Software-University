package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._8Generics._2Exercises._11Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String name = input[0] + " " + input[1];
        String address = input[2];
        String city = input[3];
        Threeuple<String, String, String> firstThreeuple = new Threeuple<>(name, address, city);
        System.out.printf("%s%n", firstThreeuple);
        input = scanner.nextLine().split("\\s+");
        String firstName = input[0];
        int littersOfBeer = Integer.parseInt(input[1]);
        boolean isDrunk = false;
        if (input[2].equals("drunk")) {
            isDrunk = true;
        }
        Threeuple<String, Integer, Boolean> secondThreeuple = new Threeuple<>(firstName, littersOfBeer, isDrunk);
        System.out.printf("%s%n", secondThreeuple);
        input = scanner.nextLine().split("\\s+");
        String nameAccount = input[0];
        double amount = Double.parseDouble(input[1]);
        String bank = input[2];
        Threeuple<String, Double, String> thirdThreeuple = new Threeuple<>(nameAccount, amount, bank);
        System.out.printf("%s%n", thirdThreeuple);
    }
}
