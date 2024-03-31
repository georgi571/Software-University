package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.entities.aquariums.Aquarium;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.entities.aquariums.FreshwaterAquarium;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.entities.aquariums.SaltwaterAquarium;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.entities.decorations.Decoration;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.entities.decorations.Ornament;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.entities.decorations.Plant;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.entities.fish.Fish;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.entities.fish.FreshwaterFish;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.entities.fish.SaltwaterFish;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.repositories.DecorationRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._02BusinessLogic.aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);
        } else if (aquariumType.equals("SaltwaterAquarium")) {
            aquarium = new SaltwaterAquarium(aquariumName);
        } else {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        this.aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        if (type.equals("Ornament")) {
            decoration = new Ornament();
        } else if (type.equals("Plant")) {
            decoration = new Plant();
        } else {
            throw new IllegalArgumentException (INVALID_DECORATION_TYPE);
        }
        this.decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = this.decorations.findByType(decorationType);
        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        for (Aquarium aquarium : this.aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                aquarium.addDecoration(decoration);
                this.decorations.remove(decoration);
                break;
            }
        }
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        Aquarium aquarium = null;
        for (Aquarium aquarium1 : this.aquariums) {
            if (aquarium1.getName().equals(aquariumName)) {
                aquarium = aquarium1;
                break;
            }
        }
        if (fishType.equals("FreshwaterFish")) {
            fish = new FreshwaterFish(fishName, fishSpecies, price);
            if (aquarium.getClass().getSimpleName().equals("SaltwaterAquarium")) {
                return String.format(WATER_NOT_SUITABLE);
            }
        } else if (fishType.equals("SaltwaterFish")) {
            fish = new SaltwaterFish(fishName, fishSpecies, price);
            if (aquarium.getClass().getSimpleName().equals("FreshwaterAquarium")) {
                return String.format(WATER_NOT_SUITABLE);
            }
        } else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        aquarium.addFish(fish);
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = null;
        for (Aquarium aquarium1 : this.aquariums) {
            if (aquarium1.getName().equals(aquariumName)) {
                aquarium = aquarium1;
                break;
            }
        }
        aquarium.feed();
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = null;
        for (Aquarium aquarium1 : this.aquariums) {
            if (aquarium1.getName().equals(aquariumName)) {
                aquarium = aquarium1;
                break;
            }
        }
        double sum = 0;
        for (Fish fish : aquarium.getFish()) {
            sum += fish.getPrice();
        }
        for (Decoration decoration : aquarium.getDecorations()) {
            sum += decoration.getPrice();
        }
        return String.format(VALUE_AQUARIUM, aquariumName, sum);
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();
        for (Aquarium aquarium : this.aquariums) {
            report.append(String.format("%s", aquarium.getInfo())).append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
