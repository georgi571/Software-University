package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._02BusinessLogic.bakery.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._02BusinessLogic.bakery.entities.bakedFoods.interfaces.BakedFood;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._02BusinessLogic.bakery.repositories.interfaces.FoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FoodRepositoryImpl implements FoodRepository<BakedFood> {
    private Collection<BakedFood> bakedFoods;

    public FoodRepositoryImpl() {
        this.bakedFoods = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        for (BakedFood bakedFood : this.bakedFoods) {
            if (bakedFood.getName().equals(name)) {
                return bakedFood;
            }
        }
        return null;
    }

    @Override
    public Collection<BakedFood> getAll() {
        return Collections.unmodifiableCollection(bakedFoods);
    }

    @Override
    public void add(BakedFood bakedFood) {
        this.bakedFoods.add(bakedFood);
    }
}
