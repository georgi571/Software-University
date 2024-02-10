package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._3Inheritance._2Exersices._06Animals.animals;

public class Cat extends Animal {
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return String.format("Meow meow");
    }
}
