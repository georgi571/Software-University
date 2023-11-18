package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._5ProgrammingFundamentalsFinalExam;

import java.util.Scanner;

public class _01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String newTex = text;
        String command = scanner.nextLine();
        while (!command.equals("Generate")) {
            String[] commandParts = command.split(">>>");
            if (commandParts[0].equals("Contains")) {
                if (newTex.contains(commandParts[1])) {
                    System.out.printf("%s contains %s%n", newTex, commandParts[1]);
                } else {
                    System.out.printf("Substring not found!%n");
                }
            } else if (commandParts[0].equals("Flip")) {
                int startIndex = Integer.parseInt(commandParts[2]);
                int endIndex = Integer.parseInt(commandParts[3]);
                if (commandParts[1].equals("Upper")) {
                    String getTex = newTex.substring(startIndex, endIndex);
                    getTex = getTex.toUpperCase();
                    newTex = newTex.substring(0, startIndex) + getTex + newTex.substring(endIndex);
                } else if (commandParts[1].equals("Lower")) {
                    String getTex = newTex.substring(startIndex, endIndex);
                    getTex = getTex.toLowerCase();
                    newTex = newTex.substring(0, startIndex) + getTex + newTex.substring(endIndex);
                }
                System.out.printf("%s%n", newTex);
            } else if (commandParts[0].equals("Slice")) {
                int startIndex = Integer.parseInt(commandParts[1]);
                int endIndex = Integer.parseInt(commandParts[2]);
                newTex = newTex.substring(0, startIndex) + newTex.substring(endIndex);
                System.out.printf("%s%n", newTex);
            }
            command = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", newTex);
    }
}
