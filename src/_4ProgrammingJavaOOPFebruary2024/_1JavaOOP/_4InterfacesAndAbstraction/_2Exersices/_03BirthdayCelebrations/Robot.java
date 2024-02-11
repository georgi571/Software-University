package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._03BirthdayCelebrations;

public class Robot implements Identifiable {
    private String model;
    private String id;

    public Robot(String id, String model) {
        this.model = model;
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
