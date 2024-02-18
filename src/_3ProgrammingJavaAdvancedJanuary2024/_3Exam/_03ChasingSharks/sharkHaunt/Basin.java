package _3ProgrammingJavaAdvancedJanuary2024._3Exam._03ChasingSharks.sharkHaunt;

import java.util.ArrayList;
import java.util.List;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public void addShark(Shark shark) {
        if (this.sharks.size() < this.capacity) {
            this.sharks.add(shark);
        } else {
            System.out.printf("This basin is at full capacity!%n");
        }
    }

    public boolean removeShark(String kind) {
        for (Shark shark : this.sharks) {
            if (shark.getKind().equals(kind)) {
                return this.sharks.remove(shark);
            }
        }
        return false;
    }

    public Shark getLargestShark() {
        Shark largestShark = null;
        for (Shark shark : this.sharks) {
            if (largestShark == null) {
                largestShark = shark;
            }
            if (shark.getLength() > largestShark.getLength()) {
                largestShark = shark;
            }
        }
        return largestShark;
    }

    public Shark getShark(String kind) {
        Shark getShark = null;
        for (Shark shark : this.sharks) {
            if (shark.getKind().equals(kind)) {
                getShark = shark;
            }
        }
        return getShark;
    }

    public int getCount() {
        return this.sharks.size();
    }

    public int getAverageLength() {
        int totalLength = 0;
        for (Shark shark : sharks) {
            totalLength += shark.getLength();
        }
        int average = totalLength / this.sharks.size();
        return average;
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Sharks in %s:%n", this.name)).trimToSize();
        for (Shark shark : this.sharks) {
            stringBuilder.append(String.format("%s%n", shark.toString()));
        }
        return stringBuilder.toString().trim();
    }
}
