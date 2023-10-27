package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._3Arrays._2Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _10TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int[] lifts = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int peopleLeft = numberOfPeople;
        for (int i = 0; i < lifts.length ; i++) {
            int peopleInCurrentLift = 0;
            if (peopleLeft >= 4) {
                if (lifts[i] == 4) {
                    peopleInCurrentLift = 0;
                } else if (lifts[i] == 3) {
                    peopleInCurrentLift = 1;
                } else if (lifts[i] == 2){
                    peopleInCurrentLift = 2;
                } else if (lifts[i] == 1){
                    peopleInCurrentLift = 3;
                } else if (lifts[i] == 0){
                    peopleInCurrentLift = 4;
                }
            } else if (peopleLeft == 3) {
                if (lifts[i] == 4) {
                    peopleInCurrentLift = 0;
                } else if (lifts[i] == 3) {
                    peopleInCurrentLift = 1;
                } else if (lifts[i] == 2){
                    peopleInCurrentLift = 2;
                } else if (lifts[i] == 1){
                    peopleInCurrentLift = 3;
                } else if (lifts[i] == 0){
                    peopleInCurrentLift = 3;
                }
            } else if (peopleLeft == 2) {
                if (lifts[i] == 4) {
                    peopleInCurrentLift = 0;
                } else if (lifts[i] == 3) {
                    peopleInCurrentLift = 1;
                } else if (lifts[i] == 2){
                    peopleInCurrentLift = 2;
                } else if (lifts[i] == 1){
                    peopleInCurrentLift = 2;
                } else if (lifts[i] == 0){
                    peopleInCurrentLift = 2;
                }
            } else if (peopleLeft == 1) {
                if (lifts[i] == 4) {
                    peopleInCurrentLift = 0;
                } else if (lifts[i] == 3) {
                    peopleInCurrentLift = 1;
                } else if (lifts[i] == 2){
                    peopleInCurrentLift = 1;
                } else if (lifts[i] == 1){
                    peopleInCurrentLift = 1;
                } else if (lifts[i] == 0){
                    peopleInCurrentLift = 1;
                }
            } else if (peopleLeft == 0) {
                break;
            }
            lifts[i] = lifts[i] + peopleInCurrentLift;
            peopleLeft -= peopleInCurrentLift;
        }
        boolean isHaveFreeSlots = false;
        for (int i = 0; i < lifts.length ; i++) {
            if (lifts[i] < 4) {
                isHaveFreeSlots = true;
                break;
            }
        }
        if (peopleLeft == 0 && !isHaveFreeSlots) {

        } else if (isHaveFreeSlots) {
            System.out.printf("The lift has empty spots!%n");
        } else if (!isHaveFreeSlots){
            System.out.printf("There isn't enough space! %d people in a queue!%n",peopleLeft);
        }
        for (int i = 0; i < lifts.length - 1; i++) {
            System.out.print(lifts[i] + " ");
        }
        System.out.print(lifts[lifts.length - 1]);
    }
}
