package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.states;

import java.util.ArrayList;
import java.util.Collection;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.common.ExceptionMessages.STATE_NAME_NULL_OR_EMPTY;

public class StateImpl implements State {
    private String name;
    private Collection<String> exhibits;

    public StateImpl(String name) {
        this.name = name;
        this.exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(STATE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
