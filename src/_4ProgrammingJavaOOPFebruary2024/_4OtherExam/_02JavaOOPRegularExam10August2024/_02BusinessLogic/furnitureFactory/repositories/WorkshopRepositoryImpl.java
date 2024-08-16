package _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.repositories;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.common.ExceptionMessages;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.workshops.Workshop;

import java.util.ArrayList;
import java.util.Collection;

public class WorkshopRepositoryImpl implements WorkshopRepository {
    private Collection<Workshop> workshops;

    public WorkshopRepositoryImpl() {
        this.workshops = new ArrayList<>();
    }

    @Override
    public void add(Workshop workshop) {
        for (Workshop currentWorkshop : this.workshops) {
            if (currentWorkshop.getClass().getSimpleName().equals(workshop.getClass().getSimpleName())) {
                throw new IllegalArgumentException(ExceptionMessages.WORKSHOP_EXISTS_IN_REPOSITORY);
            }
        }
        if (workshop.getWoodQuantity() <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.WORKSHOP_WOOD_QUANTITY_BELOW_OR_EQUAL_ZERO);
        }
        this.workshops.add(workshop);
    }

    @Override
    public boolean remove(Workshop workshop) {
        return this.workshops.remove(workshop);
    }

    @Override
    public Workshop findByType(String type) {
        for (Workshop workshop : this.workshops) {
            if (workshop.getClass().getSimpleName().equals(type)) {
                return workshop;
            }
        }
        return null;
    }
}
