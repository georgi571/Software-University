package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._9RegularExpressions._2Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06ValidatePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "_\\.+(?<passwordText>[A-Z][A-Za-z0-9]{4,}[A-Z])+_\\.+";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 1; i <= n; i++) {
            String password = scanner.nextLine();
            Matcher matcher = pattern.matcher(password);
            StringBuilder groupName = new StringBuilder();
            if (matcher.find()) {
                String getGroup = matcher.group("passwordText");
                for (char group : getGroup.toCharArray()) {
                    if(Character.isDigit(group)) {
                        groupName.append(group);
                    }
                }
                if (groupName.length() == 0) {
                    groupName.append("default");
                }
                System.out.printf("Group: %s%n", groupName);
            } else {
                System.out.printf("Invalid pass!%n");
            }
        }
    }
}
