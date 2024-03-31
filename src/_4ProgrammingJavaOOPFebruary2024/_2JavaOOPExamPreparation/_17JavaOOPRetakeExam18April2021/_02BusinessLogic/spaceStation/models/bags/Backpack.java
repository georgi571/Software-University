package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Backpack implements Bag {
    Collection<String> items;

    public Backpack() {
        this.items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return items;
    }
}
