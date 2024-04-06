package _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._01HighQualityStructure.restaurant.repositories;

import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._01HighQualityStructure.restaurant.models.waiter.Waiter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WaiterRepository implements Repository<Waiter> {
    private Collection<Waiter> waiters;

    public WaiterRepository() {
        this.waiters = new ArrayList<>();
    }

    @Override
    public Collection<Waiter> getCollection() {
        return Collections.unmodifiableCollection(waiters);
    }

    @Override
    public void add(Waiter waiter) {
        this.waiters.add(waiter);
    }

    @Override
    public boolean remove(Waiter waiter) {
        if (this.waiters.contains(waiter)) {
            this.waiters.remove(waiter);
            return true;
        }
        return false;
    }

    @Override
    public Waiter byName(String name) {
        for (Waiter waiter : this.waiters) {
            if (waiter.getName().equals(name)) {
                return waiter;
            }
        }
        return null;
    }
}
