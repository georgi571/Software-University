package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._1Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> player1 = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> player2 = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(LinkedHashSet::new));
        for (int i = 0; i < 50; i++) {
            if (player1.isEmpty() || player2.isEmpty()) {
                break;
            }
            Iterator<Integer> firstPlayerCard = player1.iterator();
            int firstCard = firstPlayerCard.next();
            firstPlayerCard.remove();
            Iterator<Integer> secondPlayerCard = player2.iterator();
            int secondCard = secondPlayerCard.next();
            secondPlayerCard.remove();
            if (firstCard > secondCard) {
                player1.add(firstCard);
                player1.add(secondCard);
            } else if (secondCard > firstCard) {
                player2.add(firstCard);
                player2.add(secondCard);
            }
        }
        if (player1.size() > player2.size()) {
            System.out.printf("First player win!%n");
        } else if (player1.size() < player2.size()) {
            System.out.printf("Second player win!%n");
        } else {
            System.out.printf("Draw!%n");
        }
    }
}
