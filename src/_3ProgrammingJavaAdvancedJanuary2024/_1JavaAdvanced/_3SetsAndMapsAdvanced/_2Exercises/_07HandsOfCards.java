package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._2Exercises;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class _07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Set<Integer>>> cards = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("JOKER")) {
            String[] commandParts = command.split(": ");
            String name = commandParts[0];
            String[] cardsForPlayer = commandParts[1].split(", ");
            for (int i = 0; i < cardsForPlayer.length; i++) {
                int powerOfCard = getCard(cardsForPlayer[i]);
                String typeOfCard = cardsForPlayer[i].substring(cardsForPlayer[i].length() - 1);
                if (cards.containsKey(name)) {
                    if (cards.get(name).containsKey(typeOfCard)) {
                        cards.get(name).get(typeOfCard).add(powerOfCard);
                    } else {
                        Set<Integer> cardsType = new TreeSet<>();
                        cardsType.add(powerOfCard);
                        cards.get(name).put(typeOfCard, cardsType);
                    }
                } else {
                    Map<String, Set<Integer>> newPlayer = new LinkedHashMap<>();
                    Set<Integer> cardsType = new TreeSet<>();
                    cardsType.add(powerOfCard);
                    newPlayer.put(typeOfCard, cardsType);
                    cards.put(name, newPlayer);
                }
            }
            command = scanner.nextLine();
        }
        cards.entrySet().forEach(entry -> {
            System.out.printf("%s: ", entry.getKey());
            AtomicInteger totalSum = new AtomicInteger();
            entry.getValue().entrySet().forEach(entry2 -> {
                int sumForcurrentType = 0;
                if (entry2.getKey().equals("S")) {
                    int sum = 0;
                    for (Integer i : entry2.getValue()) {
                        sum += i * 4;
                    }
                    sumForcurrentType += sum;
                } else if (entry2.getKey().equals("H")) {
                    int sum = 0;
                    for (Integer i : entry2.getValue()) {
                        sum += i * 3;
                    }
                    sumForcurrentType += sum;
                } else if (entry2.getKey().equals("D")) {
                    int sum = 0;
                    for (Integer i : entry2.getValue()) {
                        sum += i * 2;
                    }
                    sumForcurrentType += sum;
                } else if (entry2.getKey().equals("C")) {
                    int sum = 0;
                    for (Integer i : entry2.getValue()) {
                        sum += i;
                    }
                    sumForcurrentType += sum;
                }
                totalSum.addAndGet(sumForcurrentType);
            });
            System.out.printf("%d%n", totalSum.get());
        });
    }

    private static int getCard(String card) {
        String powerOfCard = card.substring(0 ,card.length() - 1);
        int cardPower;
        if (powerOfCard.equals("J")) {
            cardPower = 11;
        } else if (powerOfCard.equals("Q")) {
            cardPower = 12;
        }  else if (powerOfCard.equals("K")) {
            cardPower = 13;
        } else if (powerOfCard.equals("A")) {
            cardPower = 14;
        } else {
            cardPower = Integer.parseInt(powerOfCard);
        }
        return cardPower;
    }
}
