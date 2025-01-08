package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._05JavaAdvancedRetakeExam12December2024._03Geoglyphs.geoglyphs;

public class Geoglyph {
    private String name;
    private String shape;
    private int size;
    private String constructionTechnique;

    public Geoglyph(String name, String shape, int size, String constructionTechnique) {
        this.name = name;
        this.shape = shape;
        this.size = size;
        this.constructionTechnique = constructionTechnique;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getConstructionTechnique() {
        return constructionTechnique;
    }

    public void setConstructionTechnique(String constructionTechnique) {
        this.constructionTechnique = constructionTechnique;
    }

    @Override
    public String toString() {
        return String.format("%s is %d meters long and is made by %s.", this.name, this.size , this.constructionTechnique);
    }
}
