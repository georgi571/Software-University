package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._7AssociativeArrays._3MoreExercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> dwarfs = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Once upon a time")) {
            String[] inputParts = input.split(" <:> ");
            String dwarfName = inputParts[0];
            String dwarfHatColor = inputParts[1];
            int dwarfPhysics = Integer.parseInt(inputParts[2]);
            if (!dwarfs.containsKey(dwarfHatColor)) {
                LinkedHashMap<String, Integer> dwarfPoints = new LinkedHashMap<>();
                dwarfPoints.put(dwarfName, dwarfPhysics);
                dwarfs.put(dwarfHatColor, dwarfPoints);
            } else {
                if (!dwarfs.get(dwarfHatColor).containsKey(dwarfName)) {
                    dwarfs.get(dwarfHatColor).put(dwarfName, dwarfPhysics);
                } else {
                    if (dwarfs.get(dwarfHatColor).get(dwarfName) < dwarfPhysics) {
                        dwarfs.get(dwarfHatColor).put(dwarfName, dwarfPhysics);
                    }
                }
            }
            input = scanner.nextLine();
        }
        Map<String, Integer> sorting = new LinkedHashMap<>();
        for(Map.Entry<String, LinkedHashMap<String, Integer>> entry1 : dwarfs.entrySet()) {
            for(Map.Entry<String, Integer> entry2 : entry1.getValue().entrySet()) {
                sorting.put(entry1.getKey() + " " + entry2.getKey() + " " + entry1.getValue().size(), entry2.getValue());
            }
        }
        sorting.entrySet().stream().sorted((d1, d2) -> {
            int sort = Integer.compare(d2.getValue(), d1.getValue());
            if (sort == 0) {
                String[] sort1 = d2.getKey().split(" ");
                String[] sort2 = d1.getKey().split(" ");
                sort = sort1[2].compareTo(sort2[2]);
            }
            return sort;
        }).forEach(entry -> {
        String[] printing = entry.getKey().split(" ");
        System.out.printf("(%s) %s <-> %d%n", printing[0], printing[1], entry.getValue());
        });
    }
}
