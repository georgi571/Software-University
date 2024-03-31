package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ExplorerRepository implements Repository<Explorer> {
    private Collection<Explorer> explorers;

    public ExplorerRepository() {
        this.explorers = new ArrayList<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableCollection(explorers);
    }

    @Override
    public void add(Explorer explorer) {
        explorers.add(explorer);
    }

    @Override
    public boolean remove(Explorer explorer) {
        if (explorers.contains(explorer)){
            explorers.remove(explorer);
            return true;
        }
        return false;
    }

    @Override
    public Explorer byName(String name) {
        for (Explorer explorer : this.explorers) {
            if (explorer.getName().equals(name)) {
                return explorer;
            }
        }
        return null;
    }
}
