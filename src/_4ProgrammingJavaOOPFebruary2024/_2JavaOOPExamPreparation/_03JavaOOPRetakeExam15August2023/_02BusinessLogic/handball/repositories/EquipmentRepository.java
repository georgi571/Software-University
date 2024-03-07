package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.entities.equipment.Equipment;

import java.util.ArrayList;
import java.util.Collection;

public class EquipmentRepository implements Repository {
    private Collection<Equipment> equipments;

    public EquipmentRepository() {
        this.equipments = new ArrayList<>();
    }

    @Override
    public void add(Equipment equipment) {
        equipments.add(equipment);
    }

    @Override
    public boolean remove(Equipment equipment) {
        if (equipments.contains(equipment)) {
            equipments.remove(equipment);
            return true;
        }
        return false;
    }

    @Override
    public Equipment findByType(String type) {
        for (Equipment equipment : equipments) {
            if (equipment.getClass().getSimpleName().equals(type)) {
                return equipment;
            }
        }
        return null;
    }
}
