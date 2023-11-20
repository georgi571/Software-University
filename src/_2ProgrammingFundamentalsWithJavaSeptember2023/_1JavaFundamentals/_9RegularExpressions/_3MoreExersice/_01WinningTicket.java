package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._9RegularExpressions._3MoreExersice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split("\\s*,\\s+");
        Pattern pattern = Pattern.compile("(?=.{20}).*?(?=(?<ch>[@#$^]))(?<winningSymbols>\\k<ch>{6,}).*(?<=.{10})\\k<winningSymbols>.*");
        for (int i = 0; i < text.length; i++) {
            String ticket = text[i];
            if (ticket.length() != 20) {
                System.out.printf("invalid ticket%n");
            } else {
                Matcher matcher = pattern.matcher(ticket);
                boolean isMatcherFind = false;
                while (matcher.find()) {
                    String winningSymbols = matcher.group("winningSymbols");
                    char winningSymbol = winningSymbols.charAt(0);
                    int numbers = Integer.parseInt(String.valueOf(winningSymbols.length()));
                    if (numbers == 10) {
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!%n",ticket, numbers, winningSymbol);
                        isMatcherFind = true;
                    } else {
                        System.out.printf("ticket \"%s\" - %d%c%n", ticket, numbers, winningSymbol);
                        isMatcherFind = true;
                    }
                }
                if (!isMatcherFind) {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }
            }
        }
    }
}
