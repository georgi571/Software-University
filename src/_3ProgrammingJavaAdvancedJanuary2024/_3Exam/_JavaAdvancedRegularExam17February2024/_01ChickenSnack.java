package _3ProgrammingJavaAdvancedJanuary2024._3Exam._JavaAdvancedRegularExam17February2024;

import java.util.*;
import java.util.stream.Collectors;

public class _01ChickenSnack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> amount = new ArrayDeque<>();
        List<Integer> allAmount = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allAmount.size(); i++) {
            amount.push(allAmount.get(i));
        }
        Deque<Integer> price = new ArrayDeque<>();
        List<Integer> allPrice = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allPrice.size(); i++) {
            price.offer(allPrice.get(i));
        }
        int counterBuy = 0;
        while (!amount.isEmpty() && !price.isEmpty()) {
            int currentPrice = price.poll();
            int currentAmount = amount.pop();
            if (currentAmount == currentPrice) {
                counterBuy++;
            } else if (currentAmount > currentPrice) {
                currentAmount -= currentPrice;
                if (!amount.isEmpty()) {
                    currentAmount += amount.pop();
                }
                amount.push(currentAmount);
                counterBuy++;
            }
        }
        if (counterBuy >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.%n", counterBuy);
        } else if (counterBuy == 1) {
            System.out.printf("Henry ate: %d food.%n",counterBuy);
        } else if (counterBuy > 1 && counterBuy < 4) {
            System.out.printf("Henry ate: %d foods.%n",counterBuy);
        } if (counterBuy == 0) {
            System.out.printf("Henry remained hungry. He will try next weekend again.%n");
        }
    }
}
