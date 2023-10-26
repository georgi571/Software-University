package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._2Exercise;

import java.util.Scanner;

public class _01SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstTime = Integer.parseInt(scanner.nextLine());
        int secondTime = Integer.parseInt(scanner.nextLine());
        int thirdTime = Integer.parseInt(scanner.nextLine());
        int totalSeconds = firstTime + secondTime + thirdTime;
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        if (seconds < 10){
            System.out.println(minutes + ":0" + seconds);
        } else {
            System.out.println(minutes + ":" + seconds);
        }
    }
}
