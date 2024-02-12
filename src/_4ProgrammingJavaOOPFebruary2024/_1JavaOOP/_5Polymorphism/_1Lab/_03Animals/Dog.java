package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._5Polymorphism._1Lab._03Animals;

public class Dog extends Animal {
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("%s%nDJAAF", super.explainSelf());
    }
}
