package _0Softuniada._2019;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03Nexus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> array1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> array2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("nexus")) {
            String[] indexCommand = command.split("\\|");
            String[] left = indexCommand[0].split(":");
            String[] right = indexCommand[1].split(":");
            int top1 = Integer.parseInt(left[0]);
            int bot1 = Integer.parseInt(left[1]);
            int top2 = Integer.parseInt(right[0]);
            int bot2 = Integer.parseInt(right[1]);
            if ((top1 <= bot1 && top1 < top2 && bot1 > bot2)
                    || (top1 <= bot1 && top1 > top2 && bot2 > bot1)
                    || (top1 >= bot1 && top1 > top2 && bot2 > bot1)
                    || (top1 == top2)
                    || (bot1 == bot2)
                    || (top1 >= bot1 && top1 < top2 && bot1 > bot2)) {
                int sum = array1.get(top1) + array1.get(top2) + array2.get(bot1) + array2.get(bot2);
                if (top1 < top2) {
                    for (int i = top1; i <= top2; i++) {
                        array1.remove(top1);
                    }
                } else {
                    for (int i = top2; i <= top1; i++) {
                        array1.remove(top2);
                    }
                }
                if (bot1 < bot2) {
                    for (int i = bot1; i <= bot2; i++) {
                        array2.remove(bot1);
                    }
                } else {
                    for (int i = bot2; i <= bot1; i++) {
                        array2.remove(bot2);
                    }
                }
                for (int i = 0; i < array1.size(); i++) {
                    array1.set(i, array1.get(i) + sum);
                }
                for (int i = 0; i < array2.size(); i++) {
                    array2.set(i, array2.get(i) + sum);
                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < array1.size(); i++) {
            if (i < array1.size() - 1) {
                System.out.printf("%d, ", array1.get(i));
            } else {
                System.out.printf("%d%n", array1.get(i));
            }
        }
        for (int i = 0; i < array2.size(); i++) {
            if (i < array2.size() - 1) {
                System.out.printf("%d, ", array2.get(i));
            } else {
                System.out.printf("%d", array2.get(i));
            }
        }
    }
}
