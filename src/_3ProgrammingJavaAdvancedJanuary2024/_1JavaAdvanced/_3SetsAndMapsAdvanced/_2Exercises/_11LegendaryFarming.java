package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._2Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _11LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = getKeyFragments();
        Map<String, Integer> junkMaterials = new TreeMap<>();
        String legendaryItem = "";
        while (legendaryItem.equals("")) {
            String[] materials = scanner.nextLine().toLowerCase().split("\\s+");
            for (int i = 0; i < materials.length; i++) {
                putTheMaterial(keyMaterials, junkMaterials, materials[i], materials[i + 1]);
                if (materials[i + 1].equals("shards") || materials[i + 1].equals("fragments") || materials[i + 1].equals("motes")) {
                    legendaryItem = checkIfMaterialsEnough(keyMaterials, materials[i + 1], legendaryItem);
                    if (!legendaryItem.equals("")) {
                        break;
                    }
                }
                i++;
            }
        }
        System.out.printf("%s obtained!%n", legendaryItem);
        keyMaterials.entrySet().stream().sorted((k1, k2) -> keyMaterials.get(k2.getKey()).compareTo(keyMaterials.get(k1.getKey())))
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
                });
        junkMaterials.entrySet().stream().forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
                });

    }
    private static Map<String, Integer> getKeyFragments() {
        Map<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        return keyMaterials;
    }
    private static void putTheMaterial(Map<String, Integer> keyMaterials, Map<String, Integer> junkMaterials, String number, String material) {
        if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
            keyMaterials.put(material, keyMaterials.get(material) + Integer.parseInt(number));
        } else {
            if (junkMaterials.containsKey(material)) {
                junkMaterials.put(material, junkMaterials.get(material) + Integer.parseInt(number));
            } else {
                junkMaterials.put(material, Integer.parseInt(number));
            }
        }
    }
    private static String checkIfMaterialsEnough(Map<String, Integer> keyMaterials, String material, String legendaryItem) {
        if (keyMaterials.get(material) >= 250) {
            keyMaterials.put(material, keyMaterials.get(material) - 250);
            if (material.equals("shards")) {
                legendaryItem = "Shadowmourne";
            } else if (material.equals("fragments")) {
                legendaryItem = "Valanyr";
            } else if (material.equals("motes")) {
                legendaryItem = "Dragonwrath";
            }
        }
        return legendaryItem;
    }
}
