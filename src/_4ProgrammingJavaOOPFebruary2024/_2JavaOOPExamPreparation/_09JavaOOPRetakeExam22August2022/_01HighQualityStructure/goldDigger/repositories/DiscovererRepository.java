package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._01HighQualityStructure.goldDigger.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._01HighQualityStructure.goldDigger.models.discoverer.Discoverer;

import java.util.Collection;
import java.util.Collections;

public class DiscovererRepository implements Repository<Discoverer>{
    Collection<Discoverer> discoverers;
    @Override
    public Collection<Discoverer> getCollection() {
        return Collections.unmodifiableCollection(discoverers);
    }

    @Override
    public void add(Discoverer discoverer) {
        discoverers.add(discoverer);
    }

    @Override
    public boolean remove(Discoverer discoverer) {
        if (discoverers.contains(discoverer)) {
            discoverers.remove(discoverer);
            return true;
        }
        return false;
    }

    @Override
    public Discoverer byName(String name) {
        for (Discoverer discoverer : this.discoverers) {
            if (discoverer.getName().equals(name)) {
                return discoverer;
            }
        }
        return null;
    }
}
