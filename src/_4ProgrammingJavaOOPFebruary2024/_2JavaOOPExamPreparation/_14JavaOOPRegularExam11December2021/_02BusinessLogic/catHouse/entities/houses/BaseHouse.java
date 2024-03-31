package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.entities.houses;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.entities.cat.Cat;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }


    @Override
    public int sumSoftness() {
        int sum = 0;
        for (Toy toy : this.toys) {
            sum += toy.getSoftness();
        }
        return sum;
    }

    @Override
    public void addCat(Cat cat) {
        if (this.cats.size() >= this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        for (Cat cat : this.cats) {
            cat.eating();
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("%s %s:", this.name, this.getClass().getSimpleName())).append(System.lineSeparator());
        info.append("Cats:");
        if (this.cats.isEmpty()) {
            info.append(" none");
        } else {
            for (Cat cat : this.cats) {
                info.append(String.format(" %s", cat.getName()));
            }
        }
        info.append(System.lineSeparator());
        info.append(String.format("Toys: %d Softness: %d", this.toys.size(), sumSoftness())).append(System.lineSeparator());
        return info.toString().trim();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return Collections.unmodifiableCollection(cats);
    }

    @Override
    public Collection<Toy> getToys() {
        return Collections.unmodifiableCollection(toys);
    }
}
