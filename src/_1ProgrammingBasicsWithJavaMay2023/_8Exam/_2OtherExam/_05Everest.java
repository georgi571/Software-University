package _1ProgrammingBasicsWithJavaMay2023._8Exam._2OtherExam;

import java.util.Scanner;

public class _05Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = 5364;
        int end = 8848;
        int day = 1;
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if (command.equals("Yes")) {
                day++;
            }
            int meters = Integer.parseInt(scanner.nextLine());
            start += meters;
            if (start >= end) {
              break;
            }
            if (day == 5) {
                break;
            }
            command = scanner.nextLine();
        }
        if (start >= end) {
            System.out.printf("Goal reached for %d days!", day);
        } else {
            System.out.printf("Failed!%n");
            System.out.printf("%d%n", start);
        }
    }
}
