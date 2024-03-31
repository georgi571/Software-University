package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PlanetRepository implements Repository<Planet> {
    private Collection<Planet> planets;

    public PlanetRepository() {
        this.planets = new ArrayList<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(planets);
    }

    @Override
    public void add(Planet planet) {
        planets.add(planet);
    }

    @Override
    public boolean remove(Planet planet) {
        if (this.planets.contains(planet)) {
            this.planets.remove(planet);
            return true;
        }
        return false;
    }

    @Override
    public Planet findByName(String name) {
        for (Planet planet : this.planets) {
            if (planet.getName().equals(name)) {
                return planet;
            }
        }
        return null;
    }
}
