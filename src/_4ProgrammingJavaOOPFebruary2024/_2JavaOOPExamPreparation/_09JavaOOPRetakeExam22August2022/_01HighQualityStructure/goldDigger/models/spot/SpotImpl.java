package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._01HighQualityStructure.goldDigger.models.spot;

import java.util.Collection;
import java.util.Collections;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._01HighQualityStructure.goldDigger.common.ExceptionMessages.SPOT_NAME_NULL_OR_EMPTY;

public class SpotImpl implements Spot {
    private String name;
    private Collection<String> exhibits;

    public SpotImpl(String name) {
        this.setName(name);
    }

    @Override
    public Collection<String> getExhibits() {
        return Collections.unmodifiableCollection(exhibits);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SPOT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
