package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._1BasicSyntaxConditionalStatementsAndLoops._3MoreExercise;

import java.util.Scanner;

public class _01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        int number1 = 0;
        int number2 = 0;
        int number3 = 0;
        if (n1 >= n2 && n2 >= n3) {
            number1 = n1;
            number2 = n2;
            number3 = n3;
        } else if (n1 >= n3 && n3 >= n2) {
            number1 = n1;
            number2 = n3;
            number3 = n2;
        } else if (n2 >= n1 && n1 >= n3) {
            number1 = n2;
            number2 = n1;
            number3 = n3;
        } else if (n2 >= n3 && n3 >= n1) {
            number1 = n2;
            number2 = n3;
            number3 = n1;
        } else if (n3 >= n1 && n1 >= n2) {
            number1 = n3;
            number2 = n1;
            number3 = n2;
        } else if (n3 >= n2 && n2 >= n1) {
            number1 = n3;
            number2 = n2;
            number3 = n1;
        }
        System.out.printf("%d%n",number1);
        System.out.printf("%d%n",number2);
        System.out.printf("%d%n",number3);
    }
}
