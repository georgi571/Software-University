package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._8Generics._2Exercises._01GenericBox;

public class Box<T> {
    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return System.out.printf("java.lang.String: %s%n", data).toString();
    }
}
