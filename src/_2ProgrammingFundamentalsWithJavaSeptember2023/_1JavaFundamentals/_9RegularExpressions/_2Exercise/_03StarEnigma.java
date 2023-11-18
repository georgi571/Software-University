package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._9RegularExpressions._2Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<String, List<Integer>>> typeOfAction = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            String textToDecrypt = scanner.nextLine();
            StringBuilder encryptedText = new StringBuilder();
            int counter = 0;
            Pattern patternCount = Pattern.compile("[starSTAR]");
            Matcher matcherCount = patternCount.matcher(textToDecrypt);
            while (matcherCount.find()) {
                counter++;
            }
            for (char symbol : textToDecrypt.toCharArray()) {
                encryptedText.append((char) (symbol - counter));
            }
            Pattern patternPlanetInformation = Pattern.compile("@(?<planetName>[A-Za-z]+)[^@\\-!:>]*:(?<planetPopulation>[\\d]+)[^@\\-!:>]*!(?<attackType>[AD]+)![^@\\-!:>]*->(?<soldierCount>[\\d]+)");
            Matcher matcherPlanetInformation = patternPlanetInformation.matcher(encryptedText);
            int population = 0;
            int soldiers = 0;
            List<Integer> planetInformation = new ArrayList<>();
            TreeMap<String, List<Integer>> planets = new TreeMap<>();
            while (matcherPlanetInformation.find()) {
                population = Integer.parseInt(matcherPlanetInformation.group("planetPopulation"));
                soldiers = Integer.parseInt(matcherPlanetInformation.group("soldierCount"));
                planetInformation.add(population);
                planetInformation.add(soldiers);
                planets.put(matcherPlanetInformation.group("planetName"), planetInformation);
                String type = "";
                if (matcherPlanetInformation.group("attackType").equals("A")) {
                    type = "Attacked";
                } else if (matcherPlanetInformation.group("attackType").equals("D")) {
                    type = "Destroyed";
                }
                if (typeOfAction.containsKey(type)) {
                    typeOfAction.get(type).put(planets.firstKey(), planetInformation);
                } else {
                    typeOfAction.put(type, planets);
                }
            }
        }
        System.out.printf("%n");
        if (!typeOfAction.containsKey("Attacked")) {
            System.out.printf("Attacked planets: 0%n");
        }
        typeOfAction.entrySet().forEach(entry -> {
            int counter = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                counter++;
            }
            System.out.printf("%s planets: %d%n", entry.getKey() , counter);
            entry.getValue().entrySet().forEach(planet -> {
                System.out.printf("-> %s%n", planet.getKey());
            });
        });
        if (!typeOfAction.containsKey("Destroyed")) {
            System.out.printf("Destroyed planets: 0%n");
        }
    }
}
