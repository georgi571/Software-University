package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._07CollectionHierarchy.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Collection {
    private int maxSize;
    private List<String> items;

    public Collection() {
        this.items = new ArrayList<>();
        this.maxSize = 100;
    }

    protected int getMaxSize() {
        return maxSize;
    }

    protected List<String> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    protected void addLast(String item) {
        this.items.add(item);
    }

    protected void addFirst(String item) {
        this.items.add(0, item);
    }

    protected String removeFirst() {
        return this.items.remove(0);
    }

    protected String removeLast() {
        return this.items.remove(this.items.size() - 1);
    }
}
