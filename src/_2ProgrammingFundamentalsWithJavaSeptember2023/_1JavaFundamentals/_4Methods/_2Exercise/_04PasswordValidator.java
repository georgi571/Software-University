package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._2Exercise;

import java.util.Scanner;

public class _04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        boolean isValidLength = isValidLength(password);
        if (!isValidLength) {
            System.out.printf("Password must be between 6 and 10 characters%n");
        }
        boolean isValidContent = isValidContent(password);
        if (!isValidContent) {
            System.out.printf("Password must consist only of letters and digits%n");
        }
        boolean isValidCountDigit = isValidCountDigit(password);
        if (!isValidCountDigit) {
            System.out.printf("Password must have at least 2 digits%n");
        }
        if (isValidLength && isValidContent && isValidCountDigit) {
            System.out.printf("Password is valid%n");
        }
    }
    public static boolean isValidLength (String password) {
        return password.length() >= 6 && password.length() <= 10;
    }
    public static boolean isValidContent (String password) {
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isValidCountDigit (String password) {
        int countDigit = 0;
        for (char symbol : password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                countDigit++;
            }
        }
        return countDigit >= 2;
    }
}
