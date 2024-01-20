package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._8Generics._1Lab._03GenericScale;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }
    public T getHeavier() {
        if (this.left.compareTo(this.right) > 0) {
            return this.left;
        }
        if (this.left.compareTo(this.right) < 0) {
            return this.right;
        }
        return null;
    }
}
