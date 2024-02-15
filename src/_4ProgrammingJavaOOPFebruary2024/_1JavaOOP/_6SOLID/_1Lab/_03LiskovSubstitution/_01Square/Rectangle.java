package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._03LiskovSubstitution._01Square;

public class Rectangle extends Shape {
   private double width;

   private double height;

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
       return this.width*this.height;
    }
}
