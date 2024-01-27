package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._13JavaAdvancedRetakeExam15December2021._03WaterAdventure.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (!this.fishInPool.contains(fish)) {
            if (this.fishInPool.size() < capacity) {
                this.fishInPool.add(fish);
            }
        }
    }
    public boolean remove(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                return this.fishInPool.remove(fish);
            }
        }
        return false;
    }

    public Fish findFish(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public String report(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Aquarium: %s ^ Size: %d%n",getName(), getSize())).trimToSize();
        for (Fish fish : this.fishInPool) {
            stringBuilder.append(String.format("%s%n", fish.toString()));
        }
        return stringBuilder.toString().trim();
    }
}
