package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.entities.aquariums;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.entities.decorations.Decoration;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.entities.fish.Fish;

import java.util.Collection;

public interface Aquarium {
    int calculateComfort();

    String getName();

    void addFish(Fish fish);

    void removeFish(Fish fish);

    void addDecoration(Decoration decoration);

    void feed();

    String getInfo();

    Collection<Fish> getFish();

    Collection<Decoration> getDecorations();
}
