package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._7Workshop._1Lab;

import java.util.function.Consumer;

public class CustomStack<T> {
    private static final int INITIAL_CAPACITY = 4;
    private T[] data;
    private int size;
    private int capacity;

    public CustomStack() {
        this.data = (T[]) new Object[capacity];
        this.capacity = INITIAL_CAPACITY;
    }

    public CustomStack(int capacity) {
        this.capacity = INITIAL_CAPACITY;
    }

    public int getSize() {
        return this.size;
    }

    public void push(T element) {
        if (this.size == this.capacity) {
            this.resize(this.capacity * 2);
        }
        this.data[this.size++] = element;
    }

    public T pop() {
        T element = this.peek();
        if (element != null) {
            this.size--;
            if (this.size < this.capacity / 2) {
                this.resize(this.capacity / 2);
            }
        }
        return element;
    }

    public T peek() {
        if (this.size > 0) {
            return this.data[this.size - 1];
        }
        return null;
    }

    public void forEach(Consumer<T> consumer) {
        for (T datum : this.data) {
            consumer.accept(datum);
        }
    }

    private void resize(int newCapacity) {
        T[] temp = (T[]) new Object[newCapacity];
        System.arraycopy(data, 0, temp, 0, this.size);
        this.data = temp;
        this.capacity = newCapacity;
    }
}
