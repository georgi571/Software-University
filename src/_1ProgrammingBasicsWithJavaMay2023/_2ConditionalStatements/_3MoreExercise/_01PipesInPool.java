package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._3MoreExercise;

import java.util.Scanner;

public class _01PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double p1H = p1 * h;
        double p2H = p2 * h;
        double totalLitters = p1H + p2H;
        double litters = totalLitters - v;
        double percent = (totalLitters / v) * 100;
        double pipe1 = (p1H / totalLitters) * 100;
        double pipe2 = (p2H / totalLitters) * 100;
        String percentage = "%";
        if (totalLitters <= v) {
            System.out.printf("The pool is %.2f%s full. Pipe 1: %.2f%s. Pipe 2: %.2f%s.", percent, percentage, pipe1, percentage, pipe2, percentage);
        } else if (totalLitters > v) {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h, litters );
        }
    }
}
