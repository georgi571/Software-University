package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._1ProgrammingFundamentalsFinalExamRetake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> food = new ArrayList<>();
        List<String> expirationDate = new ArrayList<>();
        List<Integer> calories = new ArrayList<>();
        int totalCalories = 0;
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<symbol>[|#])(?<item>[A-Za-z\\s]+)(\\1)(?<expirationDate>\\d{2}\\/\\d{2}\\/\\d{2})(\\1)(?<calories>\\d{1,5})(\\1)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            food.add(matcher.group("item"));
            expirationDate.add(matcher.group("expirationDate"));
            int currentCalories = Integer.parseInt(matcher.group("calories"));
            totalCalories += currentCalories;
            calories.add(currentCalories);
        }
        int caloriesForDays = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", caloriesForDays);
        for (int i = 0; i < food.size(); i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n", food.get(i), expirationDate.get(i), calories.get(i));
        }
    }
}
