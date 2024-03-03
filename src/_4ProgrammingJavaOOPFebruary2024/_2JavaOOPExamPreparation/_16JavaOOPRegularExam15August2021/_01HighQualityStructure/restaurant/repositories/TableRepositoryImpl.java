package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.entities.tables.interfaces.Table;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.repositories.interfaces.TableRepository;

import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> tables;

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(tables);
    }

    @Override
    public void add(Table table) {
        tables.add(table);
    }

    @Override
    public Table byNumber(int number) {
        for (Table table : this.tables) {
            if (table.getTableNumber() == number) {
                return table;
            }
        }
        return null;
    }
}
