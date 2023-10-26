package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._1BasicSyntaxConditionalStatementsAndLoops._1Lab;

import java.util.Scanner;

public class _04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int newHours = hours;
        int newMinutes = minutes + 30;
        if (newMinutes >= 60) {
            newMinutes -= 60;
            newHours += 1;
        }
        if (newHours >= 24) {
            newHours -= 24;
        }
        System.out.printf("%d:%02d", newHours, newMinutes);
    }
}
