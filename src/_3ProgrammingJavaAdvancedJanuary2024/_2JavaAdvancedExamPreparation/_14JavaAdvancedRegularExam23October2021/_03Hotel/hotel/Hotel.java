package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._14JavaAdvancedRegularExam23October2021._03Hotel.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : this.roster) {
            if (person.getName().equals(name)) {
                return this.roster.remove(person);
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : this.roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                return person;
            }
        }
        return null;
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("The people in the hotel %s are:%n",this.name)).trimToSize();
        for (Person person : this.roster) {
            stringBuilder.append(String.format("%s%n", person));
        }
        return stringBuilder.toString().trim();
    }
}
