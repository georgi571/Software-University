package ConditionalStatementsLab;

import java.util.Scanner;

public class _07AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeFigure = scanner.nextLine();
        double area = 0;
        if (typeFigure.equals("square")){
            double a = Double.parseDouble(scanner.nextLine());
            area = a * a;
        } else if (typeFigure.equals("rectangle")){
            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            area = a * b;
        } else if (typeFigure.equals("circle")){
            double r = Double.parseDouble(scanner.nextLine());
            area = Math.PI * r * r;
        } else if (typeFigure.equals("triangle")){
            double a = Double.parseDouble(scanner.nextLine());
            double ha = Double.parseDouble(scanner.nextLine());
            area = (a * ha) / 2;
        }
        System.out.printf("%.3f", area);
    }
}
