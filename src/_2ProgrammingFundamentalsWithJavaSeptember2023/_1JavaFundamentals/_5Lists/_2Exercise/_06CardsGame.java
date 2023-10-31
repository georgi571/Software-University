package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._2Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> cardsForPlayer1 = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        List<Integer> cardsForPlayer2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        while (cardsForPlayer1.size() > 0 && cardsForPlayer2.size() > 0) {
            if (cardsForPlayer1.get(0) > cardsForPlayer2.get(0)) {
                int cardFromPlayer1 = cardsForPlayer1.get(0);
                int cardFromPlayer2 = cardsForPlayer2.get(0);
                cardsForPlayer1.remove(0);
                cardsForPlayer2.remove(0);
                cardsForPlayer1.add(cardFromPlayer1);
                cardsForPlayer1.add(cardFromPlayer2);
            } else if (cardsForPlayer1.get(0) < cardsForPlayer2.get(0)) {
                int cardFromPlayer1 = cardsForPlayer1.get(0);
                int cardFromPlayer2 = cardsForPlayer2.get(0);
                cardsForPlayer1.remove(0);
                cardsForPlayer2.remove(0);
                cardsForPlayer2.add(cardFromPlayer2);
                cardsForPlayer2.add(cardFromPlayer1);
            } else {
                int cardFromPlayer1 = cardsForPlayer1.get(0);
                int cardFromPlayer2 = cardsForPlayer2.get(0);
                cardsForPlayer1.remove(0);
                cardsForPlayer2.remove(0);
            }
        }
        int sumOfPlayer1 = 0;
        int sumOfPlayer2 = 0;
        for (Integer card : cardsForPlayer1) {
            sumOfPlayer1 += card;
        }
        for (Integer card : cardsForPlayer2) {
            sumOfPlayer2 += card;
        }
        if (sumOfPlayer1 > sumOfPlayer2) {
            System.out.printf("First player wins! Sum: %d", sumOfPlayer1);
        } else if (sumOfPlayer1 < sumOfPlayer2) {
            System.out.printf("Second player wins! Sum: %d", sumOfPlayer2);
        }
    }
}
