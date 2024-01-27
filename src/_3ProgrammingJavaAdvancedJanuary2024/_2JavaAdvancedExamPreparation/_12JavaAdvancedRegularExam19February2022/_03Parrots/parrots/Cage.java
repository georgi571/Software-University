package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._12JavaAdvancedRegularExam19February2022._03Parrots.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot datum : this.data) {
            if (datum.getName().equals(name)) {
                return this.data.remove(datum);
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        for (Parrot datum : this.data) {
            if (datum.getName().equals(name)) {
                datum.setAvailable(false);
                return datum;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> sold = new ArrayList<>();
        for (Parrot datum : this.data) {
            if (datum.getSpecies().equals(species)) {
                if (datum.isAvailable()) {
                    sold.add(datum);
                }
            }
        }
        this.data.removeAll(sold);
        return sold;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Parrots available at %s:%n", getName())).trimToSize();
        for (Parrot datum : this.data) {
            if (datum.isAvailable()) {
                stringBuilder.append(String.format("%s%n", datum.toString()));
            }
        }
        return stringBuilder.toString().trim();
    }
}
