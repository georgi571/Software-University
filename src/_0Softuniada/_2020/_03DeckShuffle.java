package _0Softuniada._2020;

import java.util.Arrays;
import java.util.Scanner;

public class _03DeckShuffle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] deck = new int[n];
        for (int i = 1; i <= n; i++) {
            deck[i - 1] = i;
        }
        int[] index = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        for (int i = 0; i < index.length; i++) {
            int[] newDeck = new int[n];
            int indexToTake = index[i];
            int[] first = new int[indexToTake];
            int[] second = new int[n - indexToTake];
            for (int j = 0; j < indexToTake; j++) {
                first[j] = deck[j];
            }
            int counterJ = 0;
            for (int j = indexToTake; j < n; j++) {
                second[counterJ] = deck[j];
                counterJ++;
            }
            int counter = 0;
            for (int j = 0; j < n; j++) {
                if (first.length > j) {
                    newDeck[counter] = first[j];
                    counter++;
                }
                if (second.length > j) {
                    newDeck[counter] = second[j];
                    counter++;
                }
            }
            deck = newDeck;
        }
        for (int i : deck) {
            System.out.printf("%d ", i);
        }
    }
}
