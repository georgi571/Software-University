package _1ProgrammingBasicsWithJavaMay2023._6NestedLoops._2Exercise;

import java.util.Scanner;

public class _04TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int juryCount = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int allGradesCount= 0;
        double sumAllGrades = 0.0;
        while (!command.equals("Finish")) {
            String presentationName = command;
            double sum = 0.0;
            for (int i = 1; i <= juryCount ; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                sum += grade;
                sumAllGrades += grade;
                allGradesCount++;
            }
            System.out.printf("%s - %.2f.%n", presentationName, sum/juryCount);
            command = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", sumAllGrades/allGradesCount);
    }
}
