package _1ProgrammingBasicsWithJavaMay2023._8Exam._2OtherExam;

import java.util.Scanner;

public class _04Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int countTo3 = 0;
        int countTo4 = 0;
        int countTo5 = 0;
        int countTo6 = 0;
        double totalGrade = 0;
        for (int i = 0; i < n; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade >= 5.00) {
                countTo6++;
            } else if (grade >= 4.00) {
                countTo5++;
            }  else if (grade >= 3.00) {
                countTo4++;
            } else {
                countTo3++;
            }
            totalGrade += grade;
        }
        System.out.printf("Top students: %.2f%%%n", (1.0 * countTo6 / n) * 100.00);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n",(1.0 * countTo5 / n) * 100.00);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n",(1.0 * countTo4 / n) * 100.00);
        System.out.printf("Fail: %.2f%%%n",(1.0 * countTo3 / n) * 100.00);
        System.out.printf("Average: %.2f%n", totalGrade / n);
    }
}
