package _0Softuniada._2020;

import java.util.Scanner;

public class _02NewSoftUniBuilding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n + (n / 2); i++) {
            int counter = 4;
            for (int j = 1; j <= n; j++) {
                if (i % 4 == 1 && counter == 4) {
                    stringBuilder.append("#");
                    counter--;
                } else if (i % 4 == 2 && counter == 4) {
                    stringBuilder.append("...#");
                    counter--;
                    j += 3;
                } else if (i % 4 == 3 && counter == 4) {
                    stringBuilder.append("..#");
                    counter--;
                    j += 2;
                }  else if (i % 4 == 0 && counter == 4) {
                    stringBuilder.append(".#");
                    counter--;
                    j += 1;
                } else if (counter > 0) {
                    stringBuilder.append(".");
                    counter--;
                } else {
                    stringBuilder.append("#");
                    counter = 3;
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        System.out.printf("%s", stringBuilder);
    }
}
