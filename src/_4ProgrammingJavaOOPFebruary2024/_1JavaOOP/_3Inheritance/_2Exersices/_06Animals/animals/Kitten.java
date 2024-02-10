package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._3Inheritance._2Exersices._06Animals.animals;

public class Kitten extends Cat {
    private static final String GENDER = "Female";
    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return String.format("Meow");
    }
}
