package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.models.guns.Gun;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> guns;

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(guns);
    }

    @Override
    public void add(Gun gun) {
        guns.add(gun);
    }

    @Override
    public boolean remove(Gun gun) {
        if (this.guns.contains(gun)) {
            this.guns.remove(gun);
            return true;
        }
        return false;
    }

    @Override
    public Gun find(String name) {
        for (Gun gun : this.guns) {
            if (gun.getName().equals(name)) {
                return gun;
            }
        }
        return null;
    }
}
