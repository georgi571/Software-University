package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022._02BusinessLogic.fairyShop.models;

import java.util.Collection;

public interface Helper {
    void work();

    void addInstrument(Instrument instrument);

    boolean canWork();

    String getName();

    int getEnergy();

    Collection<Instrument> getInstruments();
}
