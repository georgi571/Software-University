package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._7Workshop._1Lab;

import java.lang.reflect.Array;
import java.util.function.Consumer;

public class SmartArray<T> {
    private static final int INITIAL_CAPACITY = 4;
    private T[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = this.init(INITIAL_CAPACITY);
        this.capacity = INITIAL_CAPACITY;
    }

    public int size() {
        return this.size;
    }

    public void add(T element) {
        if (this.size == this.capacity) {
            this.resize(this.capacity * 2);
        }
        this.data[this.size++] = element;
    }

    public void add(int index, T element) {
        validIndex(index);
        if (this.size + 1 == this.capacity) {
            this.resize(this.capacity * 2);
        }
        T[] temp = this.init(this.capacity);
        System.arraycopy(data, 0, temp, 0, index);
        temp[index] = element;
        System.arraycopy(data, index, temp, index + 1, this.size - index);
        this.data = temp;
        this.size++;
    }

    public T get(int index) {
        validIndex(index);
        return this.data[index];
    }

    public boolean contains(T element) {
        for (T datum : this.data) {
            if (datum == element) {
                return true;
            }
        }
        return false;
    }

    public T remove(int index) {
        validIndex(index);
        T val = this.data[index];
        T[] temp = this.init(this.capacity);
        System.arraycopy(data, 0, temp, 0, index);
        System.arraycopy(data, index + 1, temp, index, this.size - index);
        this.size--;
        if (this.size < this.capacity / 2) {
            this.shrink();
        }
        return val;
    }

    public void forEach(Consumer<T> consumer) {
        for (T datum : this.data) {
            consumer.accept(datum);
        }
    }

    private void resize(int newCapacity) {
        T[] temp = this.init(newCapacity);
        System.arraycopy(data, 0, temp, 0, this.size);
        this.data = temp;
        this.capacity = newCapacity;
    }

    private void shrink() {
        this.resize(this.capacity / 2);
    }

    private void validIndex(int index) {
        if (index < 0 && index > this.size) {
            throw new IndexOutOfBoundsException("Sorry");
        }
    }


    private T[] init(int capacity) {
            return (T[]) new Object[capacity];
    }
}
