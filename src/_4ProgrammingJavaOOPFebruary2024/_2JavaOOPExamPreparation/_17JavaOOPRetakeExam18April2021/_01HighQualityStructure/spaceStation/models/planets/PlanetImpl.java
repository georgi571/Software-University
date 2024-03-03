package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._01HighQualityStructure.spaceStation.models.planets;

import java.util.Collection;
import java.util.Collections;

public class PlanetImpl implements Planet{
    private String name;
    private Collection<String> items;

    public PlanetImpl(String name) {
        this.name = name;
    }

    @Override
    public Collection<String> getItems() {
        return Collections.unmodifiableCollection(items);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
