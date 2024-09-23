package _1ProgrammingBasicsWithJavaMay2023._3ConditionalStatementsAdvanced._3MoreExercise;

import java.util.Scanner;

public class _10MultiplyBy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = Double.parseDouble(scanner.nextLine());
        double result = 0.0;
        while (n>= 0) {
            result = n*2;
            System.out.printf("Result: %.2f%n",result);
            n = Double.parseDouble(scanner.nextLine());
        }
        System.out.println("Negative number!");
    }
}
