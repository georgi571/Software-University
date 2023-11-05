package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._7AssociativeArrays._2Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _07LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> materials = new LinkedHashMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);
        boolean isLegendaryItemFind = false;
        while (!isLegendaryItemFind) {
            List<String> items = Arrays.stream(scanner.nextLine()
                                    .toLowerCase()
                                    .split(" "))
                            .collect(Collectors.toList());
            for (int i = 0; i < items.size(); i++) {
                int quantity = Integer.parseInt(items.get(i));
                i++;
                String material = items.get(i);
                if (!materials.containsKey(material)) {
                    materials.put(material, quantity);
                } else {
                    materials.put(material, materials.get(material) + quantity);
                }
                if (materials.containsKey("shards")) {
                    if (materials.get("shards") >= 250) {
                        System.out.printf("Shadowmourne obtained!%n");
                        materials.put(material, materials.get(material) - 250);
                        isLegendaryItemFind = true;
                        break;
                    }
                }
                if (materials.containsKey("fragments")) {
                    if (materials.get("fragments") >= 250) {
                        System.out.printf("Valanyr obtained!%n");
                        materials.put(material, materials.get(material) - 250);
                        isLegendaryItemFind = true;
                        break;
                    }
                }
                if (materials.containsKey("motes")) {
                    if (materials.get("motes") >= 250) {
                        System.out.printf("Dragonwrath obtained!%n");
                        materials.put(material, materials.get(material) - 250);
                        isLegendaryItemFind = true;
                        break;
                    }
                }
            }
        }
        materials.entrySet().forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }
}
