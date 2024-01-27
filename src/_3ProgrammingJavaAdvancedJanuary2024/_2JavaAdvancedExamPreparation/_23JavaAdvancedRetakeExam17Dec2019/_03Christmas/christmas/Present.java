package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._23JavaAdvancedRetakeExam17Dec2019._03Christmas.christmas;

public class Present {
    private String name;
    private double weight;
    private String gender;

    public Present(String name, double weight, String gender) {
        this.name = name;
        this.weight = weight;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("Present %s (%.2f) for a %s",getName(), getWeight(), getGender() );
    }
}
