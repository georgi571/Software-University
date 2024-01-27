package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._23JavaAdvancedRetakeExam17Dec2019._03Christmas.christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present datum : this.data) {
            if (datum.getName().equals(name)) {
                return this.data.remove(datum);
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        Present present = null;
        for (Present datum : this.data) {
            if (present == null) {
                present = datum;
            } else {
                if (datum.getWeight() > present.getWeight()) {
                    present = datum;
                }
            }
        }
        return present;
    }

    public Present getPresent(String name) {
        for (Present datum : this.data) {
            if (datum.getName().equals(name)) {
                return datum;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s bag contains:%n", getColor()));
        for (Present datum : this.data) {
            stringBuilder.append(String.format("%s%n", datum.toString()));
        }
        return stringBuilder.toString().trim();
    }
}
