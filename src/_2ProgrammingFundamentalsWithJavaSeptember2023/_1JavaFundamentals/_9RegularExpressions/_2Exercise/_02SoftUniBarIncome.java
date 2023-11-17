package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._9RegularExpressions._2Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double totalPrice = 0.0;
        while (!input.equals("end of shift")) {
            Pattern patternName = Pattern.compile("%(?<name>[A-Z][a-z]+)%");
            Pattern patternProduct = Pattern.compile("<(?<product>[\\w]+)>");
            Pattern patternCount = Pattern.compile("\\|(?<count>\\d+)\\|");
            Pattern patternPrice = Pattern.compile("(?<price>[\\d]+\\.?[\\d]*)\\$");
            Matcher matcherName = patternName.matcher(input);
            Matcher matcherProduct = patternProduct.matcher(input);
            Matcher matcherCount = patternCount.matcher(input);
            Matcher matcherPrice = patternPrice.matcher(input);
            if (matcherName.find()) {
                if (matcherProduct.find()) {
                    if (matcherCount.find()) {
                        if (matcherPrice.find()) {
                            int count = Integer.parseInt(matcherCount.group("count"));
                            double price = Double.parseDouble(matcherPrice.group("price"));
                            double priceForPerson = count * price;
                            totalPrice += priceForPerson;
                            System.out.printf("%s: %s - %.2f%n",matcherName.group("name"), matcherProduct.group("product"), priceForPerson);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalPrice);
    }
}
