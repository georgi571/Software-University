package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._3MoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> carSteps = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        int midIndex = carSteps.size() / 2;
        double timeLeftCar = 0;
        double timeRightCar = 0;
        for (int i = 0; i < midIndex; i++) {
            int currenttime = carSteps.get(i);
            if (currenttime == 0) {
                timeLeftCar *= 0.80;
            } else {
                timeLeftCar += currenttime;
            }
        }
        for (int i = carSteps.size() - 1; i > midIndex; i--) {
            int currenttime = carSteps.get(i);
            if (currenttime == 0) {
                timeRightCar *= 0.80;
            } else {
                timeRightCar += currenttime;
            }
        }
        if (timeLeftCar < timeRightCar) {
            System.out.printf("The winner is left with total time: %.1f", timeLeftCar);
        } else {
            System.out.printf("The winner is right with total time: %.1f", timeRightCar);
        }
    }
}
