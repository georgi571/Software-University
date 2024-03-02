package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022._01HighQualityStructure.fairyShop.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022._01HighQualityStructure.fairyShop.models.Helper;

import java.util.Collection;
import java.util.Collections;

public class HelperRepository implements Repository<Helper> {
    private Collection<Helper> helpers;


    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(helpers);
    }

    @Override
    public void add(Helper helper) {
        this.helpers.add(helper);
    }

    @Override
    public boolean remove(Helper helper) {
        if (this.helpers.contains(helper)) {
            this.helpers.remove(helper);
            return true;
        }
        return false;
    }

    @Override
    public Helper findByName(String name) {
        for (Helper helper : this.helpers) {
            if (helper.getName().equals(name)) {
                return helper;
            }
        }
        return null;
    }
}
