package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._1WorkingWithAbstraction._2Exersices._06GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");
        Bag bag = new Bag(capacity);
        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long amount = Long.parseLong(safe[i + 1]);
            if (name.length() == 3) {
                bag.addCash(name, amount);
            } else if (name.toLowerCase().endsWith("gem")) {
                bag.addGem(name, amount);
            } else if (name.toLowerCase().equals("gold")) {
                bag.addGold(amount);
            }
        }
        bag.printContent();
    }
}