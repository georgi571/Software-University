package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._01HighQualityStructure.easterRaces.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._01HighQualityStructure.easterRaces.entities.racers.Race;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._01HighQualityStructure.easterRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {
    private Collection<Race> races;
    @Override
    public Race getByName(String name) {
        for (Race race : this.races) {
            if (race.getName().equals(name)) {
                return race;
            }
        }
        return null;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(races);
    }

    @Override
    public void add(Race race) {
        this.races.add(race);
    }

    @Override
    public boolean remove(Race race) {
        if (this.races.contains(race)) {
            this.races.remove(race);
            return true;
        }
        return false;
    }
}
