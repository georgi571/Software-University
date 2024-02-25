package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.entities.supplements.Supplement;

import java.util.Collection;

public class SupplementRepository implements Repository{
    private Collection<Supplement> supplements;

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public boolean removeSupplement(Supplement supplement) {
        for (Supplement supplement1 : this.supplements) {
            if (supplement1.equals(supplement)) {
                supplements.remove(supplement1);
                return true;
            }
        }
        return false;
    }

    @Override
    public Supplement findFirst(String type) {
        for (Supplement supplement : this.supplements) {
            if (supplement.getClass().getSimpleName().equals(type));
        }
        return null;
    }
}
