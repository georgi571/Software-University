package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._4ProgrammingFundamentalsFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n ; i++) {
            String text = scanner.nextLine();
            Pattern pattern = Pattern.compile("(?<symbols>[@][#]+)(?<item>[A-Z][A-Za-z0-9]{4,}[A-Z])(?<symbolsENds>[@][#]+)");
            Matcher matcher = pattern.matcher(text);
            Boolean isMatchFind = false;
            while (matcher.find()) {
                String productGroup = matcher.group("item");
                String number = "";
                for (char product : productGroup.toCharArray()) {
                    if (product >= '0' && product <= '9') {
                        number += product;
                    }
                }
                if (!number.equals("")) {
                    System.out.printf("Product group: %s%n", number);
                } else {
                    System.out.printf("Product group: 00%n");
                }
                isMatchFind = true;
            }
            if (!isMatchFind) {
                System.out.printf("Invalid barcode%n");
            }
        }
    }
}
