package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._2Exercises;

import java.util.*;

public class _13DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, TreeMap<String, List<Integer>>> dragons = takeDragons(scanner);
        printOutput(dragons);
    }
    private static Map<String, TreeMap<String, List<Integer>>> takeDragons(Scanner scanner) {
        Map<String, TreeMap<String, List<Integer>>> dragons = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String type = info[0];
            String name = info[1];
            int damage = info[2].equals("null") ? 45 : Integer.parseInt(info[2]);
            int health = info[3].equals("null") ? 250 : Integer.parseInt(info[3]);
            int armor = info[4].equals("null") ? 10 : Integer.parseInt(info[4]);
            TreeMap<String, List<Integer>> dragonsName = new TreeMap<>();
            List<Integer> stats = new ArrayList<>();
            stats.add(damage);
            stats.add(health);
            stats.add(armor);
            if (dragons.containsKey(type)) {
                dragons.get(type).put(name, stats);
            } else {
                dragonsName.put(name, stats);
                dragons.put(type, dragonsName);
            }
        }
        return dragons;
    }
    private static void printOutput(Map<String, TreeMap<String, List<Integer>>> dragons) {
        dragons.entrySet().forEach(entry -> {
            int counterDragons = 0;
            double totalDamage = 0;
            double totalHealth = 0;
            double totalArmor = 0;
            for (Map.Entry<String, List<Integer>> dragon : entry.getValue().entrySet()) {
                for (int i = 0; i < dragon.getValue().size(); i++) {
                    counterDragons++;
                    totalDamage += dragon.getValue().get(0);
                    totalHealth += dragon.getValue().get(1);
                    totalArmor += dragon.getValue().get(2);
                }
            }
            double averageDamage = totalDamage / counterDragons;
            double averageHealth = totalHealth / counterDragons;
            double averageArmor = totalArmor / counterDragons;
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",entry.getKey(),averageDamage,averageHealth,averageArmor);
            entry.getValue().entrySet().forEach(dragon -> {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon.getKey(), dragon.getValue().get(0), dragon.getValue().get(1), dragon.getValue().get(2));
            });
        });
    }
}
