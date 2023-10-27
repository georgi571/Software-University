package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._4ProgrammingFundamentalsMidExam;

import java.util.Arrays;
import java.util.Scanner;

public class _03HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] houses = Arrays.stream(scanner.nextLine().split("@"))
                        .mapToInt(e -> Integer.parseInt(e))
                        .toArray();
        String command = scanner.nextLine();
        int currentIndex = 0;
        while (!command.equals("Love!")) {
            String[] jumping = command.split(" ");
            int index = Integer.parseInt(jumping[1]);
            currentIndex += index;
            if (currentIndex > houses.length - 1) {
                currentIndex = 0;
            }
            if (houses[currentIndex] == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
            } else {
                houses[currentIndex] -= 2;
                if (houses[currentIndex] <= 0) {
                    houses[currentIndex] = 0;
                    System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", currentIndex);
        boolean isAllHousesHadValentines = true;
        int failedHouses = 0;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] > 0) {
                failedHouses++;
                isAllHousesHadValentines = false;
            }
        }
        if (isAllHousesHadValentines) {
            System.out.printf("Mission was successful.%n");
        } else {
            System.out.printf("Cupid has failed %d places.%n",failedHouses);
        }
    }
}
