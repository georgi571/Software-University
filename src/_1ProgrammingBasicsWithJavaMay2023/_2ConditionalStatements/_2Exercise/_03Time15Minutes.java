package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._2Exercise;

import java.util.Scanner;

public class _03Time15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        minutes = minutes + 15;
        if (minutes > 59){
            hours = hours + 1;
            minutes = minutes - 60;
        }
        if (hours > 23){
            hours = hours - 24;
        }
        System.out.printf("%d:%02d", hours, minutes);
    }
}
