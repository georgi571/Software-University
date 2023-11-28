package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._3MoreExercise;

import java.util.Scanner;

public class _02CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        printCloseOne(x1, y1, x2, y2);
    }
    private static void printCloseOne(int x1, int y1, int x2, int y2) {
        int absOfX1 = Math.abs(x1);
        int absOfY1 = Math.abs(y1);
        int absOfX2 = Math.abs(x2);
        int absOfY2 = Math.abs(y2);
        if (absOfX1 + absOfY1 > absOfX2 + absOfY2) {
            System.out.printf("(%d, %d)%n", x2, y2);
        } else {
            System.out.printf("(%d, %d)%n", x1, y1);
        }
    }
}
