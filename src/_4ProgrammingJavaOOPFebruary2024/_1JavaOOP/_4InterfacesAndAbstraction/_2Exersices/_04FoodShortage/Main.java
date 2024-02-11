package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._04FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Rebel> rebelList = new ArrayList<>();
        List<Citizen> citizenList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input.length == 4) {
                Citizen citizen = new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]);
                citizenList.add(citizen);
            } else if (input.length == 3) {
                Rebel rebel = new Rebel(input[0], Integer.parseInt(input[1]), input[2]);
                rebelList.add(rebel);
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            for (Rebel rebel : rebelList) {
                if (rebel.getName().equals(command)) {
                    rebel.buyFood();
                }
            }
            for (Citizen citizen : citizenList) {
                if (citizen.getName().equals(command)) {
                    citizen.buyFood();
                }
            }
            command = scanner.nextLine();
        }
        int totalFood = 0;
        for (Rebel rebel : rebelList) {
            totalFood += rebel.getFood();
        }
        for (Citizen citizen : citizenList) {
            totalFood += citizen.getFood();
        }
        System.out.printf("%d%n", totalFood);
    }
}
