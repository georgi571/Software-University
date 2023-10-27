package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._2DataTypesAndVariables._3MoreExercise;

import java.util.Scanner;

public class _06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int openingSymbol = 0;
        int closingSymbol = 0;
        int openDuplication = 0;
        int closeDuplication = 0;
        for (int i = 0; i <= n; i++) {
            String randomSting = scanner.nextLine();
            if (randomSting.equals("(")) {
                openingSymbol++;
                openDuplication++;
                closeDuplication = 0;
            } else if (randomSting.equals(")")){
                closingSymbol++;
                openDuplication = 0;
                closeDuplication++;
            }
            if (openDuplication > 1 || closeDuplication > 1) {
                break;
            }
        }
        if (openingSymbol == closingSymbol) {
            System.out.printf("BALANCED");
        } else {
            System.out.printf("UNBALANCED");
        }
    }
}
