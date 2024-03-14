package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._02BusinessLogic.christmasPastryShop.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._02BusinessLogic.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._02BusinessLogic.christmasPastryShop.repositories.interfaces.CocktailRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {
    private Collection<Cocktail> cocktails;

    public CocktailRepositoryImpl() {
        this.cocktails = new ArrayList<>();
    }

    @Override
    public Cocktail getByName(String name) {
        for (Cocktail cocktail : this.cocktails) {
            if (cocktail.getName().equals(name)) {
                return cocktail;
            }
        }
        return null;
    }

    @Override
    public Collection<Cocktail> getAll() {
        return Collections.unmodifiableCollection(cocktails);
    }

    @Override
    public void add(Cocktail cocktail) {
        cocktails.add(cocktail);
    }
}
