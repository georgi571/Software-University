package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._3MoreExercise;

import java.util.Scanner;

public class _03LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        int x3 = Integer.parseInt(scanner.nextLine());
        int y3 = Integer.parseInt(scanner.nextLine());
        int x4 = Integer.parseInt(scanner.nextLine());
        int y4 = Integer.parseInt(scanner.nextLine());
        double firstSecondPointLength = getDistanceBetwin2Points(x1, y1, x2, y2);
        double thirdForthPointLength = getDistanceBetwin2Points(x3, y3, x4, y4);
        double howCloseIsFirstPoint = getDistanceBetwin2Points(x1, y1, 0, 0);
        double howCloseIsSecondPoint = getDistanceBetwin2Points(x2, y2, 0, 0);
        double howCloseIsThirdPoint = getDistanceBetwin2Points(x3, y3, 0, 0);
        double howCloseIsForthPoint = getDistanceBetwin2Points(x4, y4, 0, 0);
        printLongOne(firstSecondPointLength, thirdForthPointLength, howCloseIsFirstPoint, howCloseIsSecondPoint, howCloseIsThirdPoint, howCloseIsForthPoint, x1, y1, x2, y2, x3, y3, x4, y4);
    }
    private static double getDistanceBetwin2Points(int x1, int y1, int x2, int y2) {
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return distance;
    }
    private static void printLongOne(double firstSecondPointLength, double thirdForthPointLength, double howCloseIsFirstPoint, double howCloseIsSecondPoint, double howCloseIsThirdPoint, double howCloseIsForthPoint, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        if (firstSecondPointLength >= thirdForthPointLength) {
            if (howCloseIsFirstPoint > howCloseIsSecondPoint) {
                System.out.printf("(%d, %d)(%d, %d)%n", x2, y2, x1, y1);
            } else {
                System.out.printf("(%d, %d)(%d, %d)%n", x1, y1, x2, y2);
            }
        } else {
            if (howCloseIsThirdPoint > howCloseIsForthPoint) {
                System.out.printf("(%d, %d)(%d, %d)%n", x4, y4, x3, y3);
            } else {
                System.out.printf("(%d, %d)(%d, %d)%n", x3, y3, x4, y4);
            }
        }
    }
}