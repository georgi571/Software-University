package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._2ProgrammingFundamentalsFinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> destination = new ArrayList<>();
        int points = 0;
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<symbol>[\\/=])(?<destination>[A-Z][A-Za-z]{2,})(\\1)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String currentDestination = matcher.group("destination");
            destination.add(currentDestination);
            points += currentDestination.length();
        }
        System.out.printf("Destinations: ");
        System.out.println(String.join(", ", destination));
        System.out.printf("Travel Points: %d", points);
    }
}
