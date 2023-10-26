package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._2Exercise;

import java.util.Scanner;

public class _08LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String serialName = scanner.nextLine();
        int serialTime = Integer.parseInt(scanner.nextLine());
        int breakTime = Integer.parseInt(scanner.nextLine());
        double lunchTime = breakTime / 8.0;
        double restTime = breakTime / 4.0;
        double timeForSerialToWatch = breakTime - lunchTime - restTime;
        double diff = Math.ceil(Math.abs(timeForSerialToWatch - serialTime));
        if (timeForSerialToWatch >= serialTime) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", serialName, diff);
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", serialName, diff);
        }

    }
}
