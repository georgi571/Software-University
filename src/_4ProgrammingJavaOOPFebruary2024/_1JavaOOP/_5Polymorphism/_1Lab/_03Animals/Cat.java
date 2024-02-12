package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._5Polymorphism._1Lab._03Animals;

public class Cat extends Animal {
    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("%s%nMEEOW", super.explainSelf());
    }
}
