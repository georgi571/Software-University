package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._03LiskovSubstitution._01Square;

public class Square extends Rectangle {

    @Override
    public double getWidth() {
        return super.getWidth();
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public double getHeight() {
        return super.getHeight();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
    }
}
