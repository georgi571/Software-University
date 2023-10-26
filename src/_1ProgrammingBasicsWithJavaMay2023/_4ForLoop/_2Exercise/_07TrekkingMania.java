package _1ProgrammingBasicsWithJavaMay2023._4ForLoop._2Exercise;

import java.util.Scanner;

public class _07TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfGroups = Integer.parseInt(scanner.nextLine());
        int numberOfPeople = 0;
        int numberForMusala = 0;
        int numberForMonblan = 0;
        int numberForKilimandjaro = 0;
        int numberForK2 = 0;
        int numberForEverest = 0;
        for (int i = 1; i <= numberOfGroups; i++) {
            int numberOfPeopleInGroup = Integer.parseInt(scanner.nextLine());
            numberOfPeople += numberOfPeopleInGroup;
            if (numberOfPeopleInGroup <= 5) {
                numberForMusala += numberOfPeopleInGroup;
            } else if (numberOfPeopleInGroup <= 12) {
                numberForMonblan += numberOfPeopleInGroup;
            } else if (numberOfPeopleInGroup <= 25) {
                numberForKilimandjaro += numberOfPeopleInGroup;
            } else if (numberOfPeopleInGroup <= 40) {
                numberForK2 += numberOfPeopleInGroup;
            } else if (numberOfPeopleInGroup >= 41) {
                numberForEverest += numberOfPeopleInGroup;
            }
        }
        System.out.printf("%.2f%%%n", (1.0*numberForMusala/numberOfPeople)*100);
        System.out.printf("%.2f%%%n", (1.0*numberForMonblan/numberOfPeople)*100);
        System.out.printf("%.2f%%%n", (1.0*numberForKilimandjaro/numberOfPeople)*100);
        System.out.printf("%.2f%%%n", (1.0*numberForK2/numberOfPeople)*100);
        System.out.printf("%.2f%%%n", (1.0*numberForEverest/numberOfPeople)*100);
    }
}
