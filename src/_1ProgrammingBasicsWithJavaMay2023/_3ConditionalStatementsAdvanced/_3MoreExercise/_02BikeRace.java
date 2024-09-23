package _1ProgrammingBasicsWithJavaMay2023._3ConditionalStatementsAdvanced._3MoreExercise;

import java.util.Scanner;

public class _02BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfJuniors = Integer.parseInt(scanner.nextLine());
        int numberOfSeniors = Integer.parseInt(scanner.nextLine());
        String typeTrace = scanner.nextLine();
        double sumFromJuniors = 0.00;
        double sumFromSeniors = 0.00;
        double total = 0.00;
        int totalNumber = numberOfJuniors + numberOfSeniors;
        if (typeTrace.equals("trail")) {
            sumFromJuniors = numberOfJuniors * 5.50;
            sumFromSeniors = numberOfSeniors * 7.00;
            total = sumFromJuniors + sumFromSeniors;
        } else if (typeTrace.equals("cross-country")) {
            sumFromJuniors = numberOfJuniors * 8.00;
            sumFromSeniors = numberOfSeniors * 9.50;
            total = sumFromJuniors + sumFromSeniors;
            if (totalNumber >= 50) {
                total = 0.75 * total;
            }
        } else if (typeTrace.equals("downhill")) {
            sumFromJuniors = numberOfJuniors * 12.25;
            sumFromSeniors = numberOfSeniors * 13.75;
            total = sumFromJuniors + sumFromSeniors;
        } else if (typeTrace.equals("road")){
            sumFromJuniors = numberOfJuniors * 20.00;
            sumFromSeniors = numberOfSeniors * 21.50;
            total = sumFromJuniors + sumFromSeniors;
        }
        double expense = total * 0.05;
        double donateMoney = total - expense;
        System.out.printf("%.2f", donateMoney);
    }
}
