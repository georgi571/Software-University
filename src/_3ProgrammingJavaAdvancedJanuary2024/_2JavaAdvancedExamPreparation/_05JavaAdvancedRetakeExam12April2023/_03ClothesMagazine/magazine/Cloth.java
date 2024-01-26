package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._05JavaAdvancedRetakeExam12April2023._03ClothesMagazine.magazine;

public class Cloth {
    private String color;
    private int size;
    private String type;

    public Cloth(String color, int size, String type) {
        this.color = color;
        this.size = size;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Product: %s with size %d, color %s",getType(), getSize(), getColor());
    }
}
