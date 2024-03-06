package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DivingSiteRepository implements Repository<DivingSite> {
    private Map<String, DivingSite> sites;

    public DivingSiteRepository() {
        this.sites = new LinkedHashMap<>();
    }

    @Override
    public Collection<DivingSite> getCollection() {
        return Collections.unmodifiableCollection(sites.values());
    }

    @Override
    public void add(DivingSite site) {
        sites.put(site.getName(), site);
    }

    @Override
    public boolean remove(DivingSite site) {
        if (sites.containsKey(site.getName())) {
            sites.remove(site);
            return true;
        }
        return false;
    }

    @Override
    public DivingSite byName(String name) {
        if (sites.containsKey(name)) {
            return sites.get(name);
        }
        return null;
    }
}
