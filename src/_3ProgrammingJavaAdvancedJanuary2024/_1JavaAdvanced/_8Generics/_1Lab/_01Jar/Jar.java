package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._8Generics._1Lab._01Jar;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> stack;

    public Jar() {
        this.stack = new ArrayDeque<>();
    }
    public void add (T element) {
        this.stack.push(element);
    }
    public T remove() {
        return this.stack.pop();
    }
}
