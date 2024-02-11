package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._9IteratorsAndComparators._2Exersices._09LinkedListTraversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DoubleLinkedList<E> implements Iterable<E>{
    List<E> list;

    public DoubleLinkedList() {
        this.list = new ArrayList<>();
    }

    public void add(E data) {
        list.add(data);
    }

    public boolean remove(E data) {
        return this.list.remove(data);
    }

    public int getSize() {
        return this.list.size();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public E next() {
                return list.get(index++);
            }
        };
    }
}
