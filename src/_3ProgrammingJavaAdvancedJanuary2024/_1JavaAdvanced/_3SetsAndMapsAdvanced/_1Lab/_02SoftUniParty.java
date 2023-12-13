package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._1Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> guestList = new TreeSet<>();
        String guests = scanner.nextLine();
        while (!guests.equals("PARTY")) {
            guestList.add(guests);
            guests = scanner.nextLine();
        }
        guests = scanner.nextLine();
        while (!guests.equals("END")) {
            guestList.remove(guests);
            guests = scanner.nextLine();
        }
        System.out.printf("%d%n",guestList.size());
        for (String guest : guestList) {
            System.out.printf("%s%n", guest);
        }
    }
}
