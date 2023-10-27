package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._3ProgrammingFundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.Scanner;

public class _02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] targets = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        String command = scanner.nextLine();
        int counterShots = 0;
        while (!command.equals("End")) {
            int index = Integer.parseInt(command);
            int currentTarget = 0;
            if (index > targets.length - 1) {

            } else {
                currentTarget = targets[index];
                targets[index] = -1;
                counterShots += 1;
            }
            for (int i = 0; i < targets.length; i++) {
                if (targets[i] > -1) {
                    if (targets[i] > currentTarget) {
                        targets[i] -= currentTarget;
                    } else {
                        targets[i] += currentTarget;
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("%nShot targets: %d -> ",counterShots);
        for (int target :targets) {
            System.out.print(target + " ");
        }
    }
}
