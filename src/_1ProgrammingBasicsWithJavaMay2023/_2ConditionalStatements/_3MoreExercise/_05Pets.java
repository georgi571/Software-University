package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._3MoreExercise;

import java.util.Scanner;

public class _05Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersOfDays = Integer.parseInt(scanner.nextLine());
        int giveFoodInKg = Integer.parseInt(scanner.nextLine());
        double foodPerDayForDog = Double.parseDouble(scanner.nextLine());
        double foodPerDayForCat = Double.parseDouble(scanner.nextLine());
        double foodPerDayForTurtle = Double.parseDouble(scanner.nextLine());
        double dogFood = numbersOfDays * foodPerDayForDog;
        double catFood = numbersOfDays * foodPerDayForCat;
        double turtleFood = numbersOfDays * foodPerDayForTurtle;
        double totalFood = dogFood + catFood + (turtleFood / 1000);
        double diff = Math.abs(totalFood - giveFoodInKg);
        if (totalFood < giveFoodInKg) {
            double result = Math.floor(diff);
            System.out.printf("%.0f kilos of food left.", result);
        } else {
            double result = Math.ceil(diff);
            System.out.printf("%.0f more kilos of food are needed.", result);
        }
    }
}
