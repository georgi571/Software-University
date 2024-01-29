package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._1WorkingWithAbstraction._1Lab._02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        Point bottomCoordinates = new Point(input[0], input[1]);
        Point topCoordinates = new Point(input[2], input[3]);
        Rectangle rectangle = new Rectangle(bottomCoordinates, topCoordinates);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] checkPoint = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Point point = new Point(checkPoint[0], checkPoint[1]);
            System.out.printf("%b%n", rectangle.contains(point));
        }
    }
}
