package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._01HighQualityStructure.magicGame.repositories.interfaces;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._01HighQualityStructure.magicGame.models.magics.Magic;

import java.util.Collection;
import java.util.Collections;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._01HighQualityStructure.magicGame.common.ExceptionMessages.INVALID_MAGIC_REPOSITORY;

public class MagicRepositoryImpl implements MagicRepository {
    private Collection<Magic> data;

    @Override
    public Collection getData() {
        return Collections.unmodifiableCollection(data);
    }

    @Override
    public void addMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC_REPOSITORY);
        }
    }

    @Override
    public boolean removeMagic(Magic magic) {
        if (data.contains(magic)) {
            data.remove(magic);
            return true;
        }
        return false;
    }

    @Override
    public Object findByName(String name) {
        for (Magic magic : this.data) {
            if (magic.getName().equals(name)) {
                return magic;
            }
        }
        return null;
    }
}
