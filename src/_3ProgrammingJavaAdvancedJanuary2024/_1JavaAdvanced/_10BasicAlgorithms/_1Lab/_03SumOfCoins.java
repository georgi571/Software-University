package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._10BasicAlgorithms._1Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _03SumOfCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] elements = scanner.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }
        int targetSum = Integer.parseInt(scanner.nextLine().substring(5));
        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
        if (usedCoins.isEmpty()) {
            System.out.printf("Error%n");
        } else {
            int numberOfCoins = 0;
            for (Map.Entry<Integer, Integer> entry : usedCoins.entrySet()) {
                numberOfCoins += entry.getValue();
            }
            System.out.printf("Number of coins to take: %d%n", numberOfCoins);
        }
        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            if (usedCoin.getValue() > 0) {
                System.out.printf("%d coin(s) with value %d%n", usedCoin.getValue(), usedCoin.getKey());
            }
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        List<Integer> existCoins = new ArrayList<>();
        for (int coin : coins) {
            existCoins.add(coin);
        }
        Collections.reverse(existCoins);
        Map<Integer, Integer> coinsMap = new LinkedHashMap<>();
        for (Integer coin : existCoins) {
            if (coin.equals(50)) {
                coinsMap.put(50, 0);
            } else if (coin.equals(20)) {
                coinsMap.put(20, 0);
            } else if (coin.equals(10)) {
                coinsMap.put(10, 0);
            } else if (coin.equals(5)) {
                coinsMap.put(5, 0);
            } else if (coin.equals(2)) {
                coinsMap.put(2, 0);
            } else if (coin.equals(1)) {
                coinsMap.put(1, 0);
            }
        }
        for (Map.Entry<Integer, Integer> entry : coinsMap.entrySet()) {
            int counter = targetSum / entry.getKey();
            coinsMap.put(entry.getKey(), entry.getValue() + counter);
            targetSum -= counter * entry.getKey();
        }
        return coinsMap;
    }
}
