package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.entities.booths.interfaces.Booth;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.repositories.interfaces.BoothRepository;

import java.util.Collection;
import java.util.Collections;

public class BoothRepositoryImpl implements BoothRepository<Booth> {
    private Collection<Booth> booths;

    @Override
    public Booth getByNumber(int number) {
        for (Booth booth : this.booths) {
            if (booth.getBoothNumber() == number) {
                return booth;
            }
        }
        return null;
    }

    @Override
    public Collection<Booth> getAll() {
        return Collections.unmodifiableCollection(booths);
    }

    @Override
    public void add(Booth booth) {
        booths.add(booth);
    }
}
