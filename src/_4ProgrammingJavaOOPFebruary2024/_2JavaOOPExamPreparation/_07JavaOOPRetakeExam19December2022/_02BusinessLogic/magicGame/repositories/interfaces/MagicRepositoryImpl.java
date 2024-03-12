package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._02BusinessLogic.magicGame.repositories.interfaces;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._02BusinessLogic.magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._02BusinessLogic.magicGame.common.ExceptionMessages.INVALID_MAGIC_REPOSITORY;


public class MagicRepositoryImpl implements MagicRepository {
    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection getData() {
        return Collections.unmodifiableCollection(data);
    }

    @Override
    public void addMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC_REPOSITORY);
        }
        this.data.add(magic);
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
