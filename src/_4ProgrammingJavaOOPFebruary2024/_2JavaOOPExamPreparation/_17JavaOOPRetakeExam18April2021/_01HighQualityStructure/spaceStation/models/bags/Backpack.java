package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._01HighQualityStructure.spaceStation.models.bags;

import java.util.Collection;
import java.util.Collections;

public class Backpack implements Bag {
    Collection<String> items;
    @Override
    public Collection<String> getItems() {
        return Collections.unmodifiableCollection(items);
    }
}
