package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022._02BusinessLogic.fairyShop.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022._02BusinessLogic.fairyShop.models.Present;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PresentRepository implements Repository<Present> {
    private Collection<Present> presents;

    public PresentRepository() {
        this.presents = new ArrayList<>();
    }

    @Override
    public Collection<Present> getModels() {
        return Collections.unmodifiableCollection(presents);
    }

    @Override
    public void add(Present present) {
        this.presents.add(present);
    }

    @Override
    public boolean remove(Present present) {
        if (this.presents.contains(present)) {
            this.presents.remove(present);
            return true;
        }
        return false;
    }

    @Override
    public Present findByName(String name) {
        for (Present present : this.presents) {
            if (present.getName().equals(name)) {
                return present;
            }
        }
        return null;
    }
}
