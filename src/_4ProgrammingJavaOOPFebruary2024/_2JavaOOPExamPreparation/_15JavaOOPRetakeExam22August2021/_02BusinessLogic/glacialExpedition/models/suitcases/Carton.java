package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.suitcases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Carton implements Suitcase {
    private Collection<String> exhibits;

    public Carton() {
        this.exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }
}
