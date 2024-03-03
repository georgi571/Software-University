package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.entities.tables.interfaces.Table;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.repositories.interfaces.TableRepository;

import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> tables;
    @Override
    public Collection<Table> getAll() {
        return Collections.unmodifiableCollection(tables);
    }

    @Override
    public void add(Table table) {
        this.tables.add(table);
    }

    @Override
    public Table getByNumber(int number) {
        for (Table table : this.tables) {
            if (table.getTableNumber() == number) {
                return table;
            }
        }
        return null;
    }
}
