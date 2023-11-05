package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._7AssociativeArrays._2Exercise;

import java.util.*;

public class _03Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> products = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("buy")) {
            String[] input = command.split(" ");
            String name = input[0];
            double price = Double.parseDouble(input[1]);
            int quantity = Integer.parseInt(input[2]);
            if (!products.containsKey(name)) {
                products.put(name, new ArrayList<>());
                products.get(name).add(price);
                products.get(name).add(1.0 * quantity);
            } else {
                products.get(name).set(0, price);
                products.get(name).set(1, products.get(name).get(1) + quantity);
            }
            command = scanner.nextLine();
        }
        products.entrySet().forEach(entry -> {
            System.out.printf("%s -> ", entry.getKey());
            double sum = entry.getValue().get(0) * entry.getValue().get(1);
            System.out.printf("%.2f%n", sum);
        });
    }
}
