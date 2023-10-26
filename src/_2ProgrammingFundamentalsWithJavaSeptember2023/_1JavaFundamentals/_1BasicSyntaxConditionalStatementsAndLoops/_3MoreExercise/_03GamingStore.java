package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._1BasicSyntaxConditionalStatementsAndLoops._3MoreExercise;

import java.util.Scanner;

public class _03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = Double.parseDouble(scanner.nextLine());
        double currentBalance = balance;
        double spendInGames = 0.0;
        String command = scanner.nextLine();
        boolean isMoneyFinished = false;
        while (!command.equals("Game Time")) {
            if (command.equals("OutFall 4")){
                if (currentBalance >= 39.99) {
                    currentBalance -= 39.99;
                    spendInGames += 39.99;
                    System.out.println("Bought OutFall 4");
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (command.equals("CS: OG")){
                if (currentBalance >= 15.99) {
                    currentBalance -= 15.99;
                    spendInGames += 15.99;
                    System.out.println("Bought CS: OG");
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (command.equals("Zplinter Zell")){
                    if (currentBalance >= 19.99) {
                        currentBalance -= 19.99;
                        spendInGames += 19.99;
                        System.out.println("Bought Zplinter Zell");
                    } else {
                        System.out.println("Too Expensive");
                    }
            } else if (command.equals("Honored 2")){
                    if (currentBalance >= 59.99) {
                        currentBalance -= 59.99;
                        spendInGames += 59.99;
                        System.out.println("Bought Honored 2");
                    } else {
                        System.out.println("Too Expensive");
                    }
            } else if (command.equals("RoverWatch")){
                    if (currentBalance >= 29.99) {
                        currentBalance -= 29.99;
                        spendInGames += 29.99;
                        System.out.println("Bought RoverWatch");
                    } else {
                        System.out.println("Too Expensive");
                    }
            } else if (command.equals("RoverWatch Origins Edition")){
                    if (currentBalance >= 39.99) {
                        currentBalance -= 39.99;
                        spendInGames += 39.99;
                        System.out.println("Bought RoverWatch Origins Edition");
                    } else {
                        System.out.println("Too Expensive");
                    }
            } else {
                System.out.println("Not Found");
            }
            if (currentBalance == 0) {
                isMoneyFinished = true;
                System.out.println("Out of money!");
                break;
            }
            command = scanner.nextLine();
        }
        if (isMoneyFinished) {

        } else {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spendInGames, currentBalance);
        }
    }
}