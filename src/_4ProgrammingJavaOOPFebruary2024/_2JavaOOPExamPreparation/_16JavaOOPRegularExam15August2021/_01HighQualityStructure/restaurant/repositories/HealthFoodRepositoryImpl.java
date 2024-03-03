package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.Collection;
import java.util.Collections;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {
    private Collection<HealthyFood> healthyFoods;
    @Override
    public HealthyFood foodByName(String name) {
        for (HealthyFood healthyFood : this.healthyFoods) {
            if (healthyFood.getName().equals(name)) {
                return healthyFood;
            }
        }
        return null;
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableCollection(healthyFoods);
    }

    @Override
    public void add(HealthyFood food) {
        healthyFoods.add(food);
    }
}
