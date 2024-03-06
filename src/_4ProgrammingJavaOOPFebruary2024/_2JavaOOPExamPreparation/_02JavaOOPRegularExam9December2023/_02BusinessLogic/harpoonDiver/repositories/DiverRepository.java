package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.repositories;


import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.models.diver.Diver;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiverRepository implements Repository<Diver> {

    private Map<String, Diver> divers;

    public DiverRepository() {
        this.divers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Diver> getCollection() {
        return Collections.unmodifiableCollection(divers.values());
    }

    @Override
    public void add(Diver diver) {
        divers.put(diver.getName(), diver);
    }

    @Override
    public boolean remove(Diver diver) {
        if (divers.containsKey(diver.getName())) {
            divers.remove(diver);
            return true;
        }
        return false;
    }

    @Override
    public Diver byName(String name) {
        if (divers.containsKey(name)) {
            return divers.get(name);
        }
        return null;
    }
}
