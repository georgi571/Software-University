package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._09JavaAdvancedRetakeExam18August2022._03ElephantSanctuary.sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant){
        if (this.data.size() < capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        for (Elephant datum : this.data) {
            if (datum.getName().equals(name)) {
                return this.data.remove(datum);
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant datum : this.data) {
            if (datum.getRetiredFrom().equals(retiredFrom)) {
                return datum;
            }
        }
        return null;
    }

    public int getAllElephants() {
        return this.data.size();
    }
    public Elephant getOldestElephant() {
        Elephant elephant = null;
        for (Elephant datum : this.data) {
            if (elephant == null) {
                elephant = datum;
            } else {
                if (datum.getAge() > elephant.getAge()) {
                    elephant = datum;
                }
            }
        }
        return elephant;
    }

    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Saved elephants in the park:%n"));
        for (Elephant datum : this.data) {
            stringBuilder.append(String.format("%s came from: %s%n", datum.getName(), datum.getRetiredFrom()));
        }
        return stringBuilder.toString();
    }
}
