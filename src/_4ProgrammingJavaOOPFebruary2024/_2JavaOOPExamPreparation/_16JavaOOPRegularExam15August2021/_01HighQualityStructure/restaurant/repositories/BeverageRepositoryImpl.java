package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.entities.drinks.interfaces.Beverages;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.repositories.interfaces.BeverageRepository;

import java.util.Collection;
import java.util.Collections;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private Collection<Beverages> beverages;

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        for (Beverages beverage : this.beverages) {
            if (beverage.getName().equals(drinkName) && beverage.getBrand().equals(drinkBrand)) {
                return beverage;
            }
        }
        return null;
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(beverages);
    }

    @Override
    public void add(Beverages beverage) {
        beverages.add(beverage);
    }
}
