package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._7AssociativeArrays._2Exercise;

import java.util.*;

public class _09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> sides = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("Lumpawaroo")) {
            if (command.contains("|")) {
                String[] input = command.split(" \\| ");
                String side = input[0];
                String user = input[1];
                if (!sides.containsKey(side)) {
                    sides.put(side, new ArrayList<>());
                }
                for (Map.Entry<String, List<String>> current : sides.entrySet()) {
                    if (!current.getValue().contains(user)) {
                        sides.get(side).add(user);
                        break;
                    }
                }
            } else if (command.contains("->")) {
                String[] input = command.split(" -> ");
                String side = input[1];
                String user = input[0];
                for (Map.Entry<String, List<String>> current : sides.entrySet()) {
                    if (current.getValue().contains(user)) {
                        sides.get(current.getKey()).remove(user);
                        break;
                    }
                }
                if (!sides.containsKey(side)) {
                    sides.put(side, new ArrayList<>());
                }
                sides.get(side).add(user);
                System.out.printf("%s joins the %s side!%n", user, side);
            }
            command = scanner.nextLine();
        }
        sides.entrySet().forEach(entry -> {
            int numbers = entry.getValue().size();
            if (numbers > 0) {
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), numbers);
                entry.getValue().forEach(player -> System.out.printf("! %s%n", player));
            }
        });
    }
}
