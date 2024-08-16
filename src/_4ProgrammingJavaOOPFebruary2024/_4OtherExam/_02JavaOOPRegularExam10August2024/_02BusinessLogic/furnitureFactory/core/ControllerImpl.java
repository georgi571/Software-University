package _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.core;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.common.ConstantMessages;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.common.ExceptionMessages;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.factories.Factory;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.wood.Wood;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.repositories.WoodRepository;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.repositories.WorkshopRepository;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.factories.AdvancedFactory;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.factories.OrdinaryFactory;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.wood.OakWood;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.workshops.DeckingWorkshop;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.workshops.TableWorkshop;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.workshops.Workshop;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.repositories.WoodRepositoryImpl;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.repositories.WorkshopRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private WoodRepository woodRepository;
    private WorkshopRepository workshopRepository;
    private Collection<Factory> factories;

    public ControllerImpl() {
        this.woodRepository = new WoodRepositoryImpl();
        this.workshopRepository = new WorkshopRepositoryImpl();
        this.factories = new ArrayList<>();
    }

    @Override
    public String buildFactory(String factoryType, String factoryName) {
        Factory factory;
        if (factoryType.equals("OrdinaryFactory")) {
            factory = new OrdinaryFactory(factoryName);
        } else if (factoryType.equals("AdvancedFactory")) {
            factory = new AdvancedFactory(factoryName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FACTORY_TYPE);
        }
        for (Factory currentFactory : this.factories) {
            if (currentFactory.getName().equals(factoryName)) {
                throw new NullPointerException(ExceptionMessages.FACTORY_EXISTS);
            }
        }
        this.factories.add(factory);
        return String.format(ConstantMessages.SUCCESSFULLY_BUILD_FACTORY_TYPE, factoryType, factoryName);
    }

    @Override
    public Factory getFactoryByName(String factoryName) {
        for (Factory factory : this.factories) {
            if (factory.getName().equals(factoryName)) {
                return factory;
            }
        }
        return null;
    }

    @Override
    public String buildWorkshop(String workshopType, int woodCapacity) {
        Workshop workshop;
        if (workshopType.equals("TableWorkshop")) {
            workshop = new TableWorkshop(woodCapacity);
        } else if (workshopType.equals("DeckingWorkshop")) {
            workshop = new DeckingWorkshop(woodCapacity);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_WORKSHOP_TYPE);
        }
        this.workshopRepository.add(workshop);
        return String.format(ConstantMessages.SUCCESSFULLY_BUILD_WORKSHOP_TYPE, workshopType);
    }

    @Override
    public String addWorkshopToFactory(String factoryName, String workshopType) {
        Workshop workshop = this.workshopRepository.findByType(workshopType);
        if (workshop == null) {
            throw new NullPointerException(ExceptionMessages.NO_WORKSHOP_FOUND);
        }
        Factory factory = null;
        for (Factory factory1 : factories) {
            if (factory1.getName().equals(factoryName)) {
                factory = factory1;
            }
        }
        for (Workshop factoryWorkshop : factory.getWorkshops()) {
            if (factoryWorkshop.getClass().getSimpleName().equals(workshopType)) {
                throw new IllegalArgumentException(ExceptionMessages.WORKSHOP_EXISTS);
            }
        }
        if (factory.getClass().getSimpleName().equals("AdvancedFactory")) {
            if (workshopType.equals("TableWorkshop")) {
                return String.format(ExceptionMessages.NON_SUPPORTED_WORKSHOP);
            }
        } else if (factory.getClass().getSimpleName().equals("OrdinaryFactory")) {
            if (workshopType.equals("DeckingWorkshop")) {
                return String.format(ExceptionMessages.NON_SUPPORTED_WORKSHOP);
            }
        }
        factory.addWorkshop(workshop);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_WORKSHOP_IN_FACTORY, workshopType, factoryName);
    }


    @Override
    public String buyWoodForFactory(String woodType) {
        if (!woodType.equals("OakWood")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_WOOD_TYPE);
        }
        Wood wood = new OakWood();
        this.woodRepository.add(wood);
        return String.format(ConstantMessages.SUCCESSFULLY_BOUGHT_WOOD_FOR_FACTORY, woodType);
    }

    @Override
    public String addWoodToWorkshop(String factoryName, String workshopType, String woodType) {
        Wood wood = this.woodRepository.findByType(woodType);
        if (wood == null) {
            throw new NullPointerException(String.format(ExceptionMessages.NO_WOOD_FOUND, woodType));
        }
        Factory factory = null;
        for (Factory factory1 : this.factories) {
            if (factory1.getName().equals(factoryName)) {
                factory = factory1;
            }
        }
        for (Workshop workshop : factory.getWorkshops()) {
            if (workshop.getClass().getSimpleName().equals(workshopType)) {
                workshop.addWood(wood);
            }
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_WOOD_IN_WORKSHOP, woodType, workshopType);
    }

    @Override
    public String produceFurniture(String factoryName) {
        Factory factory = null;
        for (Factory factory1 : this.factories) {
            if (factory1.getName().equals(factoryName)) {
                factory = factory1;
            }
        }
        if (factory.getWorkshops().isEmpty()) {
            throw new NullPointerException(String.format(ExceptionMessages.THERE_ARE_NO_WORKSHOPS, factoryName));
        }
        for (Workshop workshop : factory.getWorkshops()) {
            if (workshop.getWoodQuantity() < workshop.getWoodQuantityReduceFactor()) {
                if (workshop.getWoodQuantity() <= 0) {
                    System.out.printf(ExceptionMessages.WORKSHOP_STOPPED_WORKING + "%n", workshop.getClass().getSimpleName());
                } else {
                    System.out.printf(ExceptionMessages.INSUFFICIENT_WOOD);
                }
                factory.getWorkshops().remove(workshop);
                this.workshopRepository.remove(workshop);
                factory.getRemovedWorkshops().add(workshop);
                return String.format(ExceptionMessages.FACTORY_DO_NOT_PRODUCED, factoryName);
            } else {
                workshop.produce();
                return String.format(ConstantMessages.SUCCESSFUL_PRODUCTION, 1, factoryName);
            }

        }
        return String.format(ExceptionMessages.FACTORY_DO_NOT_PRODUCED, factoryName);
    }

    @Override
    public String getReport() {
        StringBuilder statistics = new StringBuilder();
        for (Factory factory : this.factories) {
            statistics.append(String.format("Production by %s factory:", factory.getName())).append(System.lineSeparator());
            if (factory.getRemovedWorkshops().isEmpty() && factory.getWorkshops().isEmpty()) {
                statistics.append(String.format("  No workshops were added to produce furniture.")).append(System.lineSeparator());
            } else {
                for (Workshop workshop : factory.getWorkshops()) {
                    statistics.append(String.format("  %s: %s furniture produced", workshop.getClass().getSimpleName(), workshop.getProducedFurnitureCount())).append(System.lineSeparator());
                }
                for (Workshop workshop : factory.getRemovedWorkshops()) {
                    statistics.append(String.format("  %s: %s furniture produced", workshop.getClass().getSimpleName(), workshop.getProducedFurnitureCount())).append(System.lineSeparator());
                }
            }
        }
        return statistics.toString().trim();
    }
}
