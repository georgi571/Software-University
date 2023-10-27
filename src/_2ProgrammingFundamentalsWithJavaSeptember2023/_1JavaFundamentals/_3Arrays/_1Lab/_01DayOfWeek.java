package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._3Arrays._1Lab;

import java.util.Scanner;

public class _01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = Integer.parseInt(scanner.nextLine());
        String[] days = {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
        };
        if (day >= 1 && day <= days.length) {
            System.out.println(days[day - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
