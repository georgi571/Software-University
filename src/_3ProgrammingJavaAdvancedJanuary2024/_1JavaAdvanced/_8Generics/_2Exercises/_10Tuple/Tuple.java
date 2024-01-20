package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._8Generics._2Exercises._10Tuple;

public class Tuple<F, S> {
    private F first;
    private S second;

    public Tuple(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", first.toString(), second.toString());
    }
}
