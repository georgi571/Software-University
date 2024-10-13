package _1ProgrammingBasicsWithJavaMay2023._5WhileLoop._3MoreExercise;

import java.util.Scanner;

public class _01Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countDetergentBottle = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int AmountOfDetergent = countDetergentBottle * 750;
        int countWashing = 0;
        int neededDetergent = 0;
        int restOfDetergent = 0;
        int countWashedDishes = 0;
        int countWashedPots = 0;
        while (!command.equals("End")) {
            int countDishes = Integer.parseInt(command);
            countWashing++;
            if (countWashing % 3 == 0) {
                int currentWash = countDishes * 15;
                neededDetergent = neededDetergent + currentWash;
                restOfDetergent = Math.abs(AmountOfDetergent - neededDetergent);
                countWashedPots += countDishes;
            } else {
                int currentWash = countDishes * 5;
                neededDetergent = neededDetergent + currentWash;
                restOfDetergent = Math.abs(AmountOfDetergent - neededDetergent);
                countWashedDishes += countDishes;
            }
            if (neededDetergent > AmountOfDetergent) {
                break;
            }
            command = scanner.nextLine();
        }
        if (neededDetergent <= AmountOfDetergent) {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", countWashedDishes, countWashedPots);
            System.out.printf("Leftover detergent %d ml.", restOfDetergent);
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", restOfDetergent);
        }
    }
}
