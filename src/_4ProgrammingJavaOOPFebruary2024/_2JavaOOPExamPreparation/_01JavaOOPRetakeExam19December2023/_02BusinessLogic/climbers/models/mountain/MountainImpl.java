package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.mountain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.common.ExceptionMessages.MOUNTAIN_NAME_NULL_OR_EMPTY;


public class MountainImpl implements Mountain {
    private String name;
    private List<String> peaks;

    public MountainImpl(String name) {
        this.name = name;
        this.peaks = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(MOUNTAIN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getPeaksList() {
        return this.peaks;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
