package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._01HighQualityStructure.aquarium.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._01HighQualityStructure.aquarium.entities.decorations.Decoration;

import java.util.Collection;

public class DecorationRepository implements Repository {
    private Collection<Decoration> decorations;
    @Override
    public void add(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        if (this.decorations.contains(decoration)) {
            this.decorations.remove(decoration);
            return true;
        }
        return false;
    }

    @Override
    public Decoration findByType(String type) {
        for (Decoration decoration : this.decorations) {
            if (decoration.getClass().getSimpleName().equals(type)) {
                return decoration;
            }
        }
        return null;
    }
}
