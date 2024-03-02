package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.core.interfaces.Controller;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.entities.booths.interfaces.Booth;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.repositories.interfaces.BoothRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.repositories.interfaces.CocktailRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class ControllerImpl implements Controller {

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        // TODO
        return null;
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        //TODO
        return null;
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        //TODO
        return null;
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        //TODO
        return null;
    }

    @Override
    public String leaveBooth(int boothNumber) {
        //TODO
        return null;
    }

    @Override
    public String getIncome() {
        //TODO
        return null;
    }
}
