package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._7AssociativeArrays._3MoreExercises;

import java.util.*;

public class _05DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, List<Integer>>> dragonArmy = new LinkedHashMap<>();
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= number ; i++) {
            String[] input = scanner.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            String damageFromInput = input[2];
            int damage = 0;
            if (damageFromInput.equals("null")) {
                damage = 45;
            } else {
                damage = Integer.parseInt(damageFromInput);
            }
            String healthFromInput = input[3];
            int health = 0;
            if (healthFromInput.equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(healthFromInput);
            }
            String armorFromInput = input[4];
            int armor = 0;
            if (armorFromInput.equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(armorFromInput);
            }
            TreeMap<String, List<Integer>> dragonName = new TreeMap<>();
            List<Integer> stats = new ArrayList<>();
            stats.add(damage);
            stats.add(health);
            stats.add(armor);
            dragonName.put(name, stats);
            if (!dragonArmy.containsKey(type)) {
                dragonArmy.put(type, dragonName);
            } else {
                if (!dragonArmy.get(type).containsKey(name)) {
                    dragonArmy.get(type).put(name, stats);
                } else {
                    dragonArmy.get(type).put(name, stats);
                }
            }
        }
        dragonArmy.entrySet().forEach(entry -> {
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
