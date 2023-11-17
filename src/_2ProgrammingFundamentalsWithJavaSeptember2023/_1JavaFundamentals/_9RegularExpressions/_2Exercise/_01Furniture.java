package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._9RegularExpressions._2Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = ">>(?<furnitureName>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        double spendMoney = 0;
        List<String> names = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double currentPurchase= price * quantity;
                spendMoney += currentPurchase;
                names.add(matcher.group("furnitureName"));
            }
            input = scanner.nextLine();
        }
        System.out.printf("Bought furniture:%n");
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%s%n",names.get(i));
        }
        System.out.printf("Total money spend: %.2f", spendMoney);
    }
}
