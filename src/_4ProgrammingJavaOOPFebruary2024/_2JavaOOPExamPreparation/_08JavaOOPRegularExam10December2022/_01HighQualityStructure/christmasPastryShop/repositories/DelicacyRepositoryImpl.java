package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.Collection;
import java.util.Collections;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {
    private Collection<Delicacy> delicacies;

    @Override
    public Delicacy getByName(String name) {
        for (Delicacy delicacy : this.delicacies) {
            if (delicacy.getName().equals(name)) {
                return delicacy;
            }
        }
        return null;
    }

    @Override
    public Collection<Delicacy> getAll() {
        return Collections.unmodifiableCollection(delicacies);
    }

    @Override
    public void add(Delicacy delicacy) {
        this.delicacies.add(delicacy);
    }
}
