package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._24JavaAdvancedRegularExam26Oct2019._03Rabbits.rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

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

    public void add(Rabbit rabbit) {
        if (this.data.size() < capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        for (Rabbit datum : this.data) {
            if (datum.getName().equals(name)) {
                return this.data.remove(datum);
            }
        }
        return false;
    }

    public void removeSpecies(String species) {
        for (Rabbit datum : this.data) {
            if (datum.getSpecies().equals(species)) {
                this.data.remove(datum);
            }
        }
    }

    public Rabbit sellRabbit(String name) {
        for (Rabbit datum : this.data) {
            if (datum.getName().equals(name)) {
                datum.setAvailable(false);
                return datum;
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbitList  = new ArrayList<>();
        for (Rabbit datum : this.data) {
            if (datum.getSpecies().equals(species) && datum.isAvailable()) {
                rabbitList.add(datum);
            }
        }
        this.data.removeAll(rabbitList);
        return rabbitList;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Rabbits available at %s:%n",getName())).trimToSize();
        for (Rabbit datum : this.data) {
            if (datum.isAvailable()) {
                stringBuilder.append(String.format("%s%n", datum.toString()));
            }
        }
        return stringBuilder.toString().trim();
    }
}
