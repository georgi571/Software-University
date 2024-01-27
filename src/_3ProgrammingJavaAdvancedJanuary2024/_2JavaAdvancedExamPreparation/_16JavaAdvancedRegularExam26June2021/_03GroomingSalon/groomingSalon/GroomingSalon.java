package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._16JavaAdvancedRegularExam26June2021._03GroomingSalon.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet datum : this.data) {
            if (datum.getName().equals(name)) {
                return this.data.remove(datum);
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet datum : this.data) {
            if (datum.getName().equals(name) && datum.getOwner().equals(owner)) {
                return datum;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("The grooming salon has the following clients:%n")).trimToSize();
        for (Pet datum : this.data) {
            stringBuilder.append(String.format("%s %s%n", datum.getName(), datum.getOwner()));
        }
        return stringBuilder.toString().trim();
    }
}
