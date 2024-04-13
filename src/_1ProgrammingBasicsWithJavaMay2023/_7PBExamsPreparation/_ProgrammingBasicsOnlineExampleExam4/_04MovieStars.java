package _1ProgrammingBasicsWithJavaMay2023._7PBExamsPreparation._ProgrammingBasicsOnlineExampleExam4;

import java.util.Scanner;

public class _04MovieStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budgetForActors = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();
        double leftBudget = budgetForActors;
        while (!command.equals("ACTION")) {
            double salaryForTheActor;
            if (command.length() <= 15) {
                salaryForTheActor = Double.parseDouble(scanner.nextLine());
            } else {
                salaryForTheActor = leftBudget * 0.20;
            }
            leftBudget -= salaryForTheActor;
            if (leftBudget < 0) {
                break;
            }
            command = scanner.nextLine();
        }
        if (leftBudget > 0) {
            System.out.printf("We are left with %.2f leva.", leftBudget);
        } else {
            System.out.printf("We need %.2f leva for our actors.", Math.abs(leftBudget));
        }
    }
}
