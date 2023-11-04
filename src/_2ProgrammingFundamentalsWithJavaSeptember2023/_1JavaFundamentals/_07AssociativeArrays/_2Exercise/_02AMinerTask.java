package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._07AssociativeArrays._2Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> collectedResources = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("stop")) {
            String resource = command;
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!collectedResources.containsKey(resource)) {
                collectedResources.put(resource, quantity);
            } else {
                collectedResources.put(resource, collectedResources.get(resource) + quantity);
            }
            command = scanner.nextLine();
        }
        collectedResources.entrySet().forEach(entry -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));
    }
}
