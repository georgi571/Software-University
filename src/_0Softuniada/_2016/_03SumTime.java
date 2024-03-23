package _0Softuniada._2016;

import java.util.Arrays;
import java.util.Scanner;

public class _03SumTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] time1 = Arrays.stream(scanner.nextLine().split(":+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int[] time2 = Arrays.stream(scanner.nextLine().split(":+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstMinutes = 0;
        int secondMinutes = 0;
        int firstHours = 0;
        int secondHours = 0;
        int firstDays = 0;
        int secondDays = 0;
        if (time1.length == 3) {
            firstDays = time1[0];
            firstHours = time1[1];
            firstMinutes = time1[2];
        } else {
            firstHours = time1[0];
            firstMinutes = time1[1];
        }
        if (time2.length == 3) {
            secondDays = time2[0];
            secondHours = time2[1];
            secondMinutes = time2[2];
        } else {
            secondHours = time2[0];
            secondMinutes = time2[1];
        }
        int minutes = firstMinutes + secondMinutes;
        int hours = 0;
        int days = 0;
        if (minutes > 59) {
            hours++;
            minutes -= 60;
        }
        hours += (firstHours + secondHours);
        if (hours > 23) {
            days++;
            hours -= 24;
        }
        days += (firstDays + secondDays);
        if (days > 0) {
            System.out.printf("%d::%d:%02d", days, hours, minutes);
        } else {
            System.out.printf("%d:%02d", hours, minutes);
        }
    }
}
