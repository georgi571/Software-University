package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.repositories;


import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public class SupplementRepositoryImpl implements SupplementRepository {
    private Collection<Supplement> supplements;

    public SupplementRepositoryImpl() {
        this.supplements = new ArrayList<>();
    }

    @Override
    public void add(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public boolean remove(Supplement supplement) {
        if (this.supplements.contains(supplement)) {
            this.supplements.remove(supplement);
            return true;
        }
        return false;
    }

    @Override
    public Supplement findByType(String type) {
        for (Supplement supplement : this.supplements) {
            if (supplement.getClass().getSimpleName().equals(type)) {
                return supplement;
            }
        }
        return null;
    }
}
