package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._06JavaAdvancedRegularExam18February2023._03SoftUniKindergarten.kindergarten;

import java.util.*;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry ;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (this.registry.size() < capacity) {
            return this.registry.add(child);
        }
        return false;
    }
    public boolean removeChild(String firstName) {
        for (Child child : this.registry) {
            if (child.getFirstName().contains(firstName)) {
                return this.registry.remove(child);
            }
        }
        return false;
    }
    public int getChildrenCount() {
        return this.registry.size();
    }
    public Child getChild(String firstName) {
        Child children = null;
        for (Child child : this.registry) {
            if (child.getFirstName().equals(firstName)) {
                children = child;
            }
        }
        return children;
    }
    public String registryReport() {
        List<Child> sortedChildren = this.registry.stream()
                .sorted(Comparator.comparing(Child::getAge)
                        .thenComparing(Child::getFirstName)
                        .thenComparing(Child::getLastName))
                .collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Registered children in %s:%n--%n",this.name));
        for (int i = 0; i < sortedChildren.size(); i++) {
            stringBuilder.append(String.format("%s%n", sortedChildren.get(i).toString()));
            if (i < sortedChildren.size() - 1) {
                stringBuilder.append(String.format("--%n"));
            }
        }
        return stringBuilder.toString();
    }
}
