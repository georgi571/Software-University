package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._05JavaAdvancedRetakeExam12April2023._03ClothesMagazine.magazine;

import java.util.ArrayList;
import java.util.List;

public class Magazine {
    private List<Cloth> data;
    private String type;
    private int capacity;


    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void addCloth(Cloth cloth) {
        if (this.data.size() < capacity) {
            this.data.add(cloth);
        }
    }
    public boolean removeCloth(String color) {
        for (Cloth datum : this.data) {
            if (datum.getColor().equals(color)) {
                return this.data.remove(datum);
            }
        }
        return false;
    }
    public Cloth getSmallestCloth() {
        Cloth getSmallestCloth = null;
        for (Cloth datum : this.data) {
            if (getSmallestCloth == null) {
                getSmallestCloth = datum;
            } else if (datum.getSize() < getSmallestCloth.getSize()) {
                getSmallestCloth = datum;
            }
        }
        return getSmallestCloth;
    }
    public Cloth getCloth(String color) {
        Cloth getCloth = null;
        for (Cloth datum : this.data) {
            if (datum.getColor().equals(color)) {
                getCloth = datum;
            }
        }
        return getCloth;
    }
    public int getCount() {
        return this.data.size();
    }
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.type + " magazine contains:\n").trimToSize();
        for (Cloth datum : this.data) {
            stringBuilder.append(datum.toString() + "\n");
        }
        return stringBuilder.toString().trim();
    }
}
