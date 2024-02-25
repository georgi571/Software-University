package _1ProgrammingBasicsWithJavaMay2023._8Exam._2OtherExam;

import java.util.Scanner;

public class _05HairSalon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int goalForTheDay = Integer.parseInt(scanner.nextLine());
        int earnedMoney = 0;
        String command = scanner.nextLine();
        while (!command.equals("closed")) {
            String type = scanner.nextLine();
            if (command.equals("haircut")) {
                if (type.equals("mens")) {
                    earnedMoney += 15;
                } else if (type.equals("ladies")) {
                    earnedMoney += 20;
                }  else if (type.equals("kids")) {
                    earnedMoney += 10;
                }
            } else if (command.equals("color")) {
                if (type.equals("touch up")) {
                    earnedMoney += 20;
                } else if (type.equals("full color")) {
                    earnedMoney += 30;
                }
            }
            if (earnedMoney >= goalForTheDay) {
                break;
            }
            command = scanner.nextLine();
        }
        if (earnedMoney >= goalForTheDay) {
            System.out.printf("You have reached your target for the day!%n");
        } else {
            System.out.printf("Target not reached! You need %dlv. more.%n", goalForTheDay - earnedMoney);
        }
        System.out.printf("Earned money: %dlv.", earnedMoney);
    }
}
