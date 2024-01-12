package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._2Exersices._06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonList;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemonList = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }
    public boolean hasPokemonWithGivenElement(String element) {
        return this.pokemonList.stream()
                .map(Pokemon::getElement)
                .collect(Collectors.toList())
                .contains(element);
    }
    public void increaseBadges() {
        this.numberOfBadges++;
    }
    public void decreaseHealth() {
        this.pokemonList.forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
    }
    public void removeDiedPokemons() {
        this.pokemonList.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }

}
