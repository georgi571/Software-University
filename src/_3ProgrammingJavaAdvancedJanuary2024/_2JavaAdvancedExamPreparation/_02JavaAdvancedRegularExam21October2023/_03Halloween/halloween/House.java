package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._02JavaAdvancedRegularExam21October2023._03Halloween.halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void addKid(Kid kid) {
        if (data.size() < capacity) {
            this.data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        for (Kid datum : this.data) {
            if (datum.getName().equals(name)) {
                return this.data.remove(datum);
            }
        }
        return false;
    }

    public Kid getKid(String street) {
        for (Kid datum : this.data) {
            if (datum.getStreet().equals(street)) {
                return datum;
            }
        }
        return null;
    }

    public int getAllKids() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Children who visited a house for candy:\n");
        for (Kid datum : this.data) {
            stringBuilder.append(datum.getName() + " from " + datum.getStreet() + " street\n");
        }

        return stringBuilder.toString();
    }
}
