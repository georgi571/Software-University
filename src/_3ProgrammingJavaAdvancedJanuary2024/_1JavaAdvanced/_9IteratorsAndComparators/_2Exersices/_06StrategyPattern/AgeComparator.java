package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._9IteratorsAndComparators._2Exersices._06StrategyPattern;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.age, p2.age);
    }
}
