package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._08JavaAdvancedRegularExam22October2022._03AnimalShelter.shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (this.data.size() < capacity) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal datum : this.data) {
            if (datum.getName().equals(name)) {
                return this.data.remove(datum);
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        for (Animal datum : this.data) {
            if (datum.getName().equals(name) && datum.getCaretaker().equals(caretaker)) {
                return datum;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        Animal animal = null;
        for (Animal datum : this.data) {
            if (animal == null) {
                animal = datum;
            } else {
                if (datum.getAge() > animal.getAge()) {
                    animal = datum;
                }
            }
        }
        return animal;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder =  new StringBuilder();
        stringBuilder.append(String.format("The shelter has the following animals:%n"));
        for (Animal datum : this.data) {
            stringBuilder.append(String.format("%s %s%n", datum.getName(), datum.getCaretaker()));
        }
     return stringBuilder.toString();
    }
}
