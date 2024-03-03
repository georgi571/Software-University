package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.entities.drinks.interfaces.Drink;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.repositories.interfaces.DrinkRepository;

import java.util.Collection;
import java.util.Collections;

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {
    private Collection<Drink> drinks;
    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        for (Drink drink : this.drinks) {
            if (drink.getName().equals(drinkName) && drink.getBrand().equals(drinkBrand)) {
                return drink;
            }
        }
        return null;
    }

    @Override
    public Collection<Drink> getAll() {
        return Collections.unmodifiableCollection(drinks);
    }

    @Override
    public void add(Drink drink) {
        drinks.add(drink);
    }
}
