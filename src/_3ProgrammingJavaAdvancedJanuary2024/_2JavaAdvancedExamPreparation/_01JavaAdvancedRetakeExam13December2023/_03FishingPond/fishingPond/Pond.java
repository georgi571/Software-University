package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._01JavaAdvancedRetakeExam13December2023._03FishingPond.fishingPond;

import java.util.ArrayList;
import java.util.List;

public class Pond {
    private int capacity;
    private List<Fish> fishes;

    public Pond(int capacity) {
        this.capacity = capacity;
        this.fishes = new ArrayList<>();
    }

    public void addFish(Fish fish) {
        if (fishes.size() < capacity) {
            this.fishes.add(fish);
        }
    }

    public boolean removeFish(String species) {
        for (Fish fish : this.fishes) {
            if (fish.getSpecies().equals(species)) {
                return this.fishes.remove(fish);
            }
        }
        return false;
    }

    public Fish getOldestFish() {
        Fish oldestFish = null;
        for (Fish fish : this.fishes) {
            if (oldestFish == null) {
                oldestFish = fish;
            }
            if (fish.getAge() > oldestFish.getAge()) {
                oldestFish = fish;
            }
        }
        return oldestFish;
    }

    public Fish getFish(String species) {
        Fish getFish = null;
        for (Fish fish : this.fishes) {
            if (fish.getSpecies().equals(species)) {
                getFish = fish;
            }
        }
        return getFish;
    }

    public int getCount() {
        return this.fishes.size();
    }

    public int getVacancies() {
        return this.capacity - this.fishes.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fishes in the pond:\n");
        for (Fish fish : this.fishes) {
            stringBuilder.append("This " + fish.getSpecies() + " is " + fish.getAge() + " years old and reproduces through " + fish.getMatingSeason() +".\n");
        }

        return stringBuilder.toString();
    }
}
