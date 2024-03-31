package _3ProgrammingJavaAdvancedJanuary2024._3Exam._JavaAdvancedRegularExam17February2024._03ChasingSharks.sharkHaunt;

public class Shark {
    private String kind;
    private int length;
    private String food;
    private String habitation;

    public Shark(String kind, int length, String food, String habitation) {
        this.kind = kind;
        this.length = length;
        this.food = food;
        this.habitation = habitation;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getHabitation() {
        return habitation;
    }

    public void setHabitation(String habitation) {
        this.habitation = habitation;
    }

    @Override
    public String toString() {
        return String.format("The %s is %d centimeters long, eats %s and inhabits %s.", getKind(), getLength(), getFood(),getHabitation());
    }
}
