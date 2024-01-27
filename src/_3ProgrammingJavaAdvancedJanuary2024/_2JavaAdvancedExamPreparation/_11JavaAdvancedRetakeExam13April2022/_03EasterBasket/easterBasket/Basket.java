package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._11JavaAdvancedRetakeExam13April2022._03EasterBasket.easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (this.data.size() < capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg datum : this.data) {
            if (datum.getColor().equals(color)) {
                return this.data.remove(datum);
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        Egg egg = null;
        for (Egg datum : this.data) {
            if (egg == null) {
                egg = datum;
            } else {
                if (datum.getStrength() > egg.getStrength()) {
                    egg = datum;
                }
            }
        }
        return egg;
    }

    public Egg getEgg(String color) {
        for (Egg datum : this.data) {
            if (datum.getColor().equals(color)) {
                return datum;
            }
        }
        return null;
    }
    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s basket contains:%n", this.material)).trimToSize();
        for (Egg datum : this.data) {
            stringBuilder.append(String.format("%s%n", datum.toString()));
        }
        return stringBuilder.toString().trim();
    }
}
