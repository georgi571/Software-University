package _1ProgrammingBasicsWithJavaMay2023._5WhileLoop._2Exercise;

import java.util.Scanner;

public class _02ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfBadGrades = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int sumGrade = 0;
        int gradesCounter = 0;
        String lastProblem = "";
        int badGradesCount = 0;
        boolean isFailed = false;
        while (!command.equals("Enough")) {
            String taskName = command;
            int grade = Integer.parseInt(scanner.nextLine());
            sumGrade += grade;
            gradesCounter += 1;
            lastProblem = taskName;
            if (grade <= 4) {
                badGradesCount += 1;
            }
            if (badGradesCount == numberOfBadGrades) {
                isFailed = true;
                break;
            }
            command = scanner.nextLine();
        }
        if (isFailed) {
            System.out.printf("You need a break, %d poor grades.", numberOfBadGrades);
        } else {
            double averageGrade = 1.0 * sumGrade / gradesCounter;
            System.out.printf("Average score: %.2f%n", averageGrade);
            System.out.printf("Number of problems: %d%n", gradesCounter);
            System.out.printf("Last problem: %s", lastProblem);
        }
    }
}
