package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.astronauts.Astronaut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AstronautRepository implements Repository<Astronaut> {
    private Collection<Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new ArrayList<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(astronauts);
    }

    @Override
    public void add(Astronaut astronaut) {
        astronauts.add(astronaut);
    }

    @Override
    public boolean remove(Astronaut astronaut) {
        if (this.astronauts.contains(astronaut)) {
            astronauts.remove(astronaut);
            return true;
        }
        return false;
    }

    @Override
    public Astronaut findByName(String name) {
        for (Astronaut astronaut : this.astronauts) {
            if (astronaut.getName().equals(name)) {
                return astronaut;
            }
        }
        return null;
    }
}
