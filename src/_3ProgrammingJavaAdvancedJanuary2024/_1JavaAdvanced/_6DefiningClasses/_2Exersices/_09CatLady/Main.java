package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._2Exersices._09CatLady;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String ,Hierarchy> cats = new LinkedHashMap<>();
        while (!command.equals("End")) {
            Hierarchy hierarchy = new Hierarchy();
            String[] commandParts = command.split("\\s+");
            String breeds = commandParts[0];
            String name = commandParts[1];
            double characteristic = Double.parseDouble(commandParts[2]);
            hierarchy.setBreeds(breeds);
            hierarchy.setName(name);
            if (breeds.equals("Siamese")) {
                hierarchy.setEarSize(characteristic);
            } else if (breeds.equals("Cymric")) {
                hierarchy.setFurLength(characteristic);
            } else if (breeds.equals("StreetExtraordinaire")) {
                hierarchy.setDecibelsOfMeows(characteristic);
            }
            cats.put(name ,hierarchy);
            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        for (Map.Entry<String, Hierarchy> entry : cats.entrySet()) {
            if (entry.getKey().equals(command)) {
                Hierarchy hierarchy = entry.getValue();
                hierarchy.printCatInfo(hierarchy);
            }
        }
    }
}
