package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SpotRepository implements Repository<Spot> {
    Collection<Spot> spots;

    public SpotRepository() {
        this.spots = new ArrayList<>();
    }

    @Override
    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(spots);
    }

    @Override
    public void add(Spot spot) {
        spots.add(spot);
    }

    @Override
    public boolean remove(Spot spot) {
        if (spots.contains(spot)) {
            spots.remove(spot);
            return true;
        }
        return false;
    }

    @Override
    public Spot byName(String name) {
        for (Spot spot : this.spots) {
            if (spot.getName().equals(name)) {
                return spot;
            }
        }
        return null;
    }
}
