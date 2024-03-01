package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._01HighQualityStructure.magicGame.repositories.interfaces;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._01HighQualityStructure.magicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.Collections;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._01HighQualityStructure.magicGame.common.ExceptionMessages.INVALID_MAGICIAN_REPOSITORY;

public class MagicianRepositoryImpl implements MagicianRepository {
    private Collection<Magician> data;

    @Override
    public Collection getData() {
        return Collections.unmodifiableCollection(data);
    }

    @Override
    public void addMagician(Magician magician) {
        if (magician == null) {
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }
        data.add(magician);
    }

    @Override
    public boolean removeMagician(Magician magician) {
        if (data.contains(magician)) {
            data.remove(magician);
            return true;
        }
        return false;
    }

    @Override
    public Object findByUsername(String name) {
        for (Magician magician : this.data) {
            if (magician.getUsername().equals(name)) {
                return magician;
            }
        }
        return null;
    }
}
