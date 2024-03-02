package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._01HighQualityStructure.catHouse.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._01HighQualityStructure.catHouse.entities.toys.Toy;

import java.util.Collection;

public class ToyRepository implements Repository {
    private Collection<Toy> toys;
    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        if (this.toys.contains(toy)) {
            this.toys.remove(toy);
            return true;
        }
        return false;
    }

    @Override
    public Toy findFirst(String type) {
        for (Toy toy : this.toys) {
            if (toy.getClass().getSimpleName().equals(type)) {
                return toy;
            }
        }
        return null;
    }
}
