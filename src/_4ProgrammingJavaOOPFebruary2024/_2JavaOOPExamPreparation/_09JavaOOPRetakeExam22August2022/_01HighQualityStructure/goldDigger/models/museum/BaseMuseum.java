package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._01HighQualityStructure.goldDigger.models.museum;

import java.util.Collection;
import java.util.Collections;

public class BaseMuseum implements Museum {
    private Collection<String> exhibits;

    @Override
    public Collection<String> getExhibits() {
        return Collections.unmodifiableCollection(exhibits);
    }
}
