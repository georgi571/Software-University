package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._01HighQualityStructure.glacialExpedition.models.suitcases;

import java.util.Collection;
import java.util.Collections;

public class Carton implements Suitcase {
    private Collection<String> exhibits;
    @Override
    public Collection<String> getExhibits() {
        return Collections.unmodifiableCollection(exhibits);
    }
}
