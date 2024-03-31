package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StateRepository implements Repository<State> {
    private Collection<State> states;

    public StateRepository() {
        this.states = new ArrayList<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableCollection(states);
    }

    @Override
    public void add(State state) {
        states.add(state);
    }

    @Override
    public boolean remove(State state) {
        if (states.contains(state)) {
            states.remove(state);
            return true;
        }
        return false;
    }

    @Override
    public State byName(String name) {
        for (State state : this.states) {
            if (state.getName().equals(name)) {
                return state;
            }
        }
        return null;
    }
}
