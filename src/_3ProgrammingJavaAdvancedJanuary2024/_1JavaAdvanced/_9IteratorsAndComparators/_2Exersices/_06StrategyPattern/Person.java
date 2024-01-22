package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._9IteratorsAndComparators._2Exersices._06StrategyPattern;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", name, age);
    }
}
