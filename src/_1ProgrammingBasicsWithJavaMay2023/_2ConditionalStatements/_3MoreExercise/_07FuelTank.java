package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._3MoreExercise;

import java.util.Scanner;

public class _07FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOfPetrol = scanner.nextLine();
        double littersOfPetrol = Double.parseDouble(scanner.nextLine());
        if (typeOfPetrol.equals("Diesel")) {
            if (littersOfPetrol >= 25) {
                System.out.println("You have enough diesel.");
            } else if (littersOfPetrol < 25)
                System.out.println("Fill your tank with diesel!");
        } else if (typeOfPetrol.equals("Gasoline")) {
            if (littersOfPetrol >= 25) {
                System.out.println("You have enough gasoline.");
            } else if (littersOfPetrol < 25)
                System.out.println("Fill your tank with gasoline!");
        } else if (typeOfPetrol.equals("Gas")) {
            if (littersOfPetrol >= 25) {
                System.out.println("You have enough gas.");
            } else if (littersOfPetrol < 25)
                System.out.println("Fill your tank with gas!");
        } else {
            System.out.println("Invalid fuel!");
        }
    }
}
