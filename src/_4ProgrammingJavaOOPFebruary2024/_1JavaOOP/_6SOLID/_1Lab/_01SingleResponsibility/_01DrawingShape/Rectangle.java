package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._01SingleResponsibility._01DrawingShape;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._01SingleResponsibility._01DrawingShape.interfaces.DrawingRepository;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._01SingleResponsibility._01DrawingShape.interfaces.Rengerer;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._01SingleResponsibility._01DrawingShape.interfaces.Shape;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

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

    public double getArea() {
       return this.height*this.width;
    }

    @Override
    public void draw(Rengerer rengerer, DrawingRepository drawingRepository) {
        rengerer.render(drawingRepository,this);

    }
}
