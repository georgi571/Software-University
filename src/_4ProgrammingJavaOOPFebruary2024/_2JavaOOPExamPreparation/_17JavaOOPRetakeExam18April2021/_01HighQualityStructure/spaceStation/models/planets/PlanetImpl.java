package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._01HighQualityStructure.spaceStation.models.planets;

import java.util.ArrayList;
import java.util.Collection;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._01HighQualityStructure.spaceStation.common.ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY;

public class PlanetImpl implements Planet{
    private String name;
    private Collection<String> items;

    public PlanetImpl(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    private void setName(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new NullPointerException(PLANET_NAME_NULL_OR_EMPTY);
            }
            this.name = name;
        }

    @Override
    public Collection<String> getItems() {
        return items;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
