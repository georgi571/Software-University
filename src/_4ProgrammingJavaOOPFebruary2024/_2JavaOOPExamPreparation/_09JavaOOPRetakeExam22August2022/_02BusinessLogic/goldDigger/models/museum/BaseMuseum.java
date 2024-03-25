package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.models.museum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BaseMuseum implements Museum {
    private Collection<String> exhibits;

    public BaseMuseum() {
        this.exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }
}
