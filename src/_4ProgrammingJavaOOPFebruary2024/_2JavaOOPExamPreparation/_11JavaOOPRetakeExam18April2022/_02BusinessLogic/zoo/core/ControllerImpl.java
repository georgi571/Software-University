package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.entities.animals.Animal;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.entities.animals.AquaticAnimal;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.entities.animals.TerrestrialAnimal;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.entities.areas.Area;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.entities.areas.LandArea;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.entities.areas.WaterArea;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.entities.foods.Food;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.entities.foods.Meat;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.entities.foods.Vegetable;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.repositories.FoodRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        if (areaType.equals("WaterArea")) {
            area = new WaterArea(areaName);
        } else if (areaType.equals("LandArea")) {
            area = new LandArea(areaName);
        } else {
            throw new NullPointerException(INVALID_AREA_TYPE);
        }
        this.areas.add(area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        if (foodType.equals("Vegetable")) {
            food = new Vegetable();
        } else if (foodType.equals("Meat")) {
            food = new Meat();
        } else {
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        this.foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        for (Area area : this.areas) {
            if (area.getName().equals(areaName)) {
                Food food = this.foodRepository.findByType(foodType);
                if (food == null) {
                    throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
                }
                area.addFood(food);
                this.foodRepository.remove(food);
            }
        }
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA,foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal = null;
        Area area = null;
        for (Area area1 : this.areas) {
            if (area1.getName().equals(areaName)) {
                area = area1;
                break;
            }
        }
        if (animalType.equals("AquaticAnimal")) {
            if (area.getClass().getSimpleName().equals("WaterArea")) {
                animal = new AquaticAnimal(animalName, kind, price);
                area.addAnimal(animal);
            }
        } else if (animalType.equals("TerrestrialAnimal")) {
            if (area.getClass().getSimpleName().equals("LandArea")) {
                animal = new TerrestrialAnimal(animalName, kind, price);
                area.addAnimal(animal);
            }
        } else {
            throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }
        if (animal == null) {
            return String.format(AREA_NOT_SUITABLE);
        }
        return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        int sum = 0;
        for (Area area : this.areas) {
            if (area.getName().equals(areaName)) {
                area.feed();
                sum += area.getAnimals().size();
                break;
            }
        }
        return String.format(ANIMALS_FED, sum);
    }

    @Override
    public String calculateKg(String areaName) {
        double sum = 0;
        for (Area area : this.areas) {
            if (area.getName().equals(areaName)) {
                for (Animal animal : area.getAnimals()) {
                    sum += animal.getKg();
                }
                break;
            }
        }
        return String.format(KILOGRAMS_AREA, areaName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Area area : this.areas) {
            stringBuilder.append(String.format("%s", area.getInfo())).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
