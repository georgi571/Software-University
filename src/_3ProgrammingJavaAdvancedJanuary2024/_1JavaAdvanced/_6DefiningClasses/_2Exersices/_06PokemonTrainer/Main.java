package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._2Exersices._06PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("Tournament")) {
            String[] commandParts = command.split("\\s+");
            String trainerName = commandParts[0];
            String pokemonName = commandParts[1];
            String pokemonType = commandParts[2];
            int pokemonHealth = Integer.parseInt(commandParts[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonType, pokemonHealth);
            Trainer trainer;
            if (trainerMap.containsKey(trainerName)) {
                trainer = trainerMap.get(trainerName);
            } else {
                trainer = new Trainer(trainerName);
            }
            trainer.addPokemon(pokemon);
            trainerMap.putIfAbsent(trainerName, trainer);
            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        while (!command.equals("End")) {
            String element = command;
            trainerMap.values().forEach(trainer -> {
                if (trainer.hasPokemonWithGivenElement(element)) {
                    trainer.increaseBadges();
                } else {
                    trainer.decreaseHealth();
                    trainer.removeDiedPokemons();
                }
            });
            command = scanner.nextLine();
        }
        trainerMap.values()
                .stream().sorted((t1, t2) -> Integer.compare(t2.getNumberOfBadges(), t1.getNumberOfBadges()))
                .forEach(entry -> {
            System.out.printf("%s %d %d%n", entry.getName(), entry.getNumberOfBadges(), entry.getPokemonList().size());
        });
    }
}
