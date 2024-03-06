package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.mountain.Mountain;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class MountainRepository implements Repository<Mountain> {
    private Map<String, Mountain> mountains;

    public MountainRepository() {
        this.mountains = new LinkedHashMap<>();
    }

    @Override
    public Collection<Mountain> getCollection() {
        return Collections.unmodifiableCollection(mountains.values());
    }

    @Override
    public void add(Mountain mountain) {
        mountains.put(mountain.getName(), mountain);
    }

    @Override
    public boolean remove(Mountain mountain) {
        if (mountains.containsKey(mountain.getName())) {
            mountains.remove(mountain.getName());
            return true;
        }
        return false;
    }

    @Override
    public Mountain byName(String name) {
        if (mountains.containsKey(name)) {
            return mountains.get(name);
        }
        return null;
    }
}
