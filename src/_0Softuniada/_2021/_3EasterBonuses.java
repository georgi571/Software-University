package _0Softuniada._2021;

import java.util.Arrays;
import java.util.Scanner;

public class _3EasterBonuses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int totalBonus = 0;
        while (!command.equals("stop")) {
            int currentBonus = 0;
            int[] tasks = Arrays.stream(scanner.nextLine().split(",\\s+"))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            for (int i = 0; i < tasks.length; i++) {
                int count = 1;
                for (int j = 0; j < tasks.length; j++) {
                    if (j != i) {
                        count *= tasks[j];
                    }
                }
                currentBonus += count;
            }
            totalBonus += currentBonus;
            System.out.printf("%s has a bonus of %d lv.%n", command, currentBonus);
            command = scanner.nextLine();
        }
        System.out.printf("The amount of all bonuses is %d lv.", totalBonus);
    }
}
