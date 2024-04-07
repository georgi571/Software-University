package _0Softuniada._2024;


import java.util.HashMap;
import java.util.Scanner;

public class _06PalindromicNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        largestPalindrome(input);
    }

    static boolean possibility(HashMap<Integer, Integer> map, int length, String string) {
        int countodd = 0;
        for (int i = 0; i < length; i++) {
            if (map.get(string.charAt(i) - '0') % 2 == 1)
                countodd++;
            if (countodd > 1)
                return false;
        }
        return true;
    }

    static void largestPalindrome(String string) {
        int length = string.length();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(string.charAt(i) - '0')) {
                map.put(string.charAt(i) - '0', map.get(string.charAt(i) - '0') + 1);
            } else {
                map.put(string.charAt(i) - '0', 1);
            }
        }
        if (possibility(map, length, string) == false) {
            System.out.print("No palindromic number available.");
            return;
        }
        char[] largest = new char[length];
        int front = 0;
        for (int i = 9; i >= 0; i--) {
            if (map.containsKey(i) && map.get(i) % 2 == 1) {
                largest[length / 2] = (char) (i + 48);
                map.put(i, map.get(i) - 1);
                while (map.get(i) > 0) {
                    largest[front] = (char) (i + 48);
                    largest[length - front - 1] =
                            (char) (i + 48);
                    map.put(i, map.get(i) - 2);
                    front++;
                }
            } else {
                while (map.containsKey(i) && map.get(i) > 0) {
                    largest[front] = (char) (i + 48);
                    largest[length - front - 1] = (char) (i + 48);
                    map.put(i, map.get(i) - 2);
                    front++;
                }
            }
        }
        for (int i = 0; i < length; i++)
            System.out.print(largest[i]);
    }
}