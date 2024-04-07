package _0Softuniada._2024;

import java.util.Scanner;

public class _02ChampionsCup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int s = n * 3;
        int nextN = n;
        for (int i = 0; i < n / 2; i++) {
            String prefix = new String(new char[nextN]).replace('\0', '.');
            String suffix = new String(new char[nextN]).replace('\0', '.');
            StringBuilder symbols = new StringBuilder();
            for (int j = 0; j < (n * 3) - (i * 2); j++) {
                symbols.append("#");
            }
            System.out.println(prefix + symbols + suffix);
            nextN++;
            s -= 2;
        }
        for (int i = 0; i < n / 2 + 1; i++) {
            String prefix = new String(new char[nextN]).replace('\0', '.');
            String suffix = new String(new char[nextN]).replace('\0', '.');
            StringBuilder symbols = new StringBuilder();
            symbols.append("#");
            for (int j = 0; j < s - 2; j++) {
                symbols.append(".");
            }
            symbols.append("#");
            System.out.println(prefix + symbols + suffix);
            nextN++;
            s -= 2;
        }
        nextN--;
        for (int i = 0; i < 1; i++) {
            String prefix = new String(new char[nextN]).replace('\0', '.');
            String suffix = new String(new char[nextN]).replace('\0', '.');
            StringBuilder symbols = new StringBuilder();
            for (int j = 0; j < n; j++) {
                symbols.append("#");
            }
            System.out.println(prefix + symbols + suffix);
        }
        for (int i = 0; i < n / 2; i++) {
            String prefix = new String(new char[nextN - 2]).replace('\0', '.');
            String suffix = new String(new char[nextN - 2]).replace('\0', '.');
            StringBuilder symbols = new StringBuilder();
            for (int j = 0; j < n + 4; j++) {
                symbols.append("#");
            }
            System.out.println(prefix + symbols + suffix);
        }
        for (int i = 0; i < 1; i++) {
            String prefix = null;
            String suffix = null;
            StringBuilder symbols = new StringBuilder();
            symbols.append("D^A^N^C^E^");
            prefix = new String(new char[((n * 5) - 10) / 2]).replace('\0', '.');
            suffix = new String(new char[((n * 5) - 10) / 2]).replace('\0', '.');
            System.out.println(prefix + symbols + suffix);
        }
        for (int i = 0; i < n / 2 + 1; i++) {
            String prefix = new String(new char[nextN - 2]).replace('\0', '.');
            String suffix = new String(new char[nextN - 2]).replace('\0', '.');
            StringBuilder symbols = new StringBuilder();
            for (int j = 0; j < n + 4; j++) {
                symbols.append("#");
            }
            System.out.println(prefix + symbols + suffix);
        }
    }
}

