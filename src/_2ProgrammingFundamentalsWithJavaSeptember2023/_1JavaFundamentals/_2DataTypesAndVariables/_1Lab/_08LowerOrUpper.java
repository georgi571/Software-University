package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._2DataTypesAndVariables._1Lab;

import java.util.Scanner;

public class _08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char char1 = scanner.nextLine().charAt(0);
        if (char1 >= 65 && char1 <= 90) {
            System.out.println("upper-case");
        } else if (char1 >= 97 && char1 <= 122) {
            System.out.println("lower-case");
        }
    }
}
