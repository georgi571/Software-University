package _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._01HighQualityStructure.furnitureFactory.repositories;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._01HighQualityStructure.furnitureFactory.entities.wood.Wood;

import java.util.ArrayList;
import java.util.Collection;

public class WoodRepositoryImpl implements WoodRepository {
    private Collection<Wood> woodTypes;

    public WoodRepositoryImpl() {
        this.woodTypes = new ArrayList<>();
    }

    @Override
    public void add(Wood wood) {
        this.woodTypes.add(wood);
    }

    @Override
    public boolean remove(Wood wood) {
        return this.woodTypes.remove(wood);
    }

    @Override
    public Wood findByType(String type) {
        for (Wood woodType : this.woodTypes) {
            if (woodType.getClass().getSimpleName().equals(type)) {
                return woodType;
            }
        }
        return null;
    }
}
