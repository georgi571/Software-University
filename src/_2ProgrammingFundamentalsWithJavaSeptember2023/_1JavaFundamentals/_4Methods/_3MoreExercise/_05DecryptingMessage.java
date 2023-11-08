package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._3MoreExercise;

import java.util.Scanner;

public class _05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        String word = "";
        for (int i = 1; i <= n; i++) {
            char letter = scanner.nextLine().charAt(0);
            letter += key;
            word += letter;
        }
        System.out.printf("%s%n", word);
    }
}
