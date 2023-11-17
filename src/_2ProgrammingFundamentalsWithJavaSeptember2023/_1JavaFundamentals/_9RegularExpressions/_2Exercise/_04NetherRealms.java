package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._9RegularExpressions._2Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] demonNames = scanner.nextLine().split("\\s*,\\s*");
        for (String demon : demonNames){
            int health = 0;
            double damage = 0.0;
            Pattern patternForHealth = Pattern.compile("([^\\+\\-*\\/0-9\\.])");
            Matcher matcherForHealth = patternForHealth.matcher(demon);
            while (matcherForHealth.find()) {
                health += (int) matcherForHealth.group().charAt(0);
            }
            Pattern patternForDmg = Pattern.compile("[-]?\\d+[\\.]?\\d*");
            Matcher matcherForDmg = patternForDmg.matcher(demon);
            while (matcherForDmg.find()) {
                double number = Double.parseDouble(matcherForDmg.group());
                damage += number;
            }
            for (char demonChar : demon.toCharArray()) {
                if (demonChar == '*') {
                    damage *= 2;
                }
                if (demonChar == '/') {
                    damage /= 2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n", demon, health, damage);
        }
    }
}
