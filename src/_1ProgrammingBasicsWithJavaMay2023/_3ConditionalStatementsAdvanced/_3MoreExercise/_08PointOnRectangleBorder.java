package _1ProgrammingBasicsWithJavaMay2023._3ConditionalStatementsAdvanced._3MoreExercise;

import java.util.Scanner;

public class _08PointOnRectangleBorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        if (x == x1 || x == x2) {
            if (y >= y1 && y <= y2) {
                System.out.println("Border");
            } else {
                System.out.println("Inside / Outside");
            }
        }
        else if (y == y1 || y == y2) {
            if (x >= x1 && x <= x2) {
                System.out.println("Border");
            } else {
                System.out.println("Inside / Outside");
            }
        }
        else {
            System.out.println("Inside / Outside");
        }
    }
}
