package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.entities.cat.Cat;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.entities.cat.LonghairCat;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.entities.cat.ShorthairCat;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.entities.houses.House;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.entities.houses.LongHouse;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.entities.houses.ShortHouse;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.entities.toys.Ball;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.entities.toys.Mouse;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.entities.toys.Toy;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.repositories.Repository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._02BusinessLogic.catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        if (type.equals("ShortHouse")) {
            house = new ShortHouse(name);
        } else if (type.equals("LongHouse")) {
            house = new LongHouse(name);
        } else {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        this.houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        if (type.equals("Ball")) {
            toy = new Ball();
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        this.toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }
        for (House house : this.houses) {
            if (house.getName().equals(houseName)) {
                house.buyToy(toy);
                this.toys.removeToy(toy);
                break;
            }
        }
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        House house = this.houses.stream().filter(house1 -> house1.getName().equals(houseName)).findFirst().orElse(null);
        if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);
                if (house.getClass().getSimpleName().equals("ShortHouse")) {
                    house.addCat(cat);
                    return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
                }
        } else if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
            if (house.getClass().getSimpleName().equals("LongHouse")) {
                house.addCat(cat);
                return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
            }
        } else {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        return String.format(UNSUITABLE_HOUSE);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = this.houses.stream().filter(house1 -> house1.getName().equals(houseName)).findFirst().orElse(null);
        house.feeding();
        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = this.houses.stream().filter(house1 -> house1.getName().equals(houseName)).findFirst().orElse(null);
        double sum = 0;
        for (Toy toy : house.getToys()) {
            sum += toy.getPrice();
        }
        for (Cat cat : house.getCats()) {
            sum += cat.getPrice();
        }
        return String.format(VALUE_HOUSE, houseName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        for (House house : this.houses) {
            statistics.append(String.format("%s", house.getStatistics())).append(System.lineSeparator());
        }
        return statistics.toString().trim();
    }
}
