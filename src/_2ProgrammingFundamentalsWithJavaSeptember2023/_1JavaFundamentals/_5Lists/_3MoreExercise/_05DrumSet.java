package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._3MoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        List<Integer> newDrumSet = new ArrayList<>();
        for (Integer drum : drumSet) {
            newDrumSet.add(drum);
        }
        String command = scanner.nextLine();
        while (!command.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(command);
            for (int i = 0; i < newDrumSet.size(); i++) {
                newDrumSet.set(i, newDrumSet.get(i) - hitPower);
            }
            for (int i = 0; i < newDrumSet.size(); i++) {
                if (newDrumSet.get(i) <= 0) {
                    double neededMoney = drumSet.get(i) * 3;
                    if (savings >= neededMoney) {
                        newDrumSet.set(i, drumSet.get(i));
                        savings -= neededMoney;
                    } else {
                        newDrumSet.remove(i);
                        drumSet.remove(i);
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < newDrumSet.size() - 1; i++) {
            System.out.printf("%d ", newDrumSet.get(i));
        }
        System.out.printf("%d%n",newDrumSet.get(newDrumSet.size() - 1));
        System.out.printf("Gabsy has %.2flv.",savings);
    }
}
