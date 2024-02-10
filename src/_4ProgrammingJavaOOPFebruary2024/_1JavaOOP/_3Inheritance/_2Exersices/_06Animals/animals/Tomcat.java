package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._3Inheritance._2Exersices._06Animals.animals;

public class Tomcat extends Cat {
    private static final String GENDER = "Male";
    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return String.format("MEOW");
    }
}
