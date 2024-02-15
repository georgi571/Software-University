package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._02OpenClosedPrinciple._02DrawingShape;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._02OpenClosedPrinciple._02DrawingShape.interfaces.DrawingManager;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._02OpenClosedPrinciple._02DrawingShape.interfaces.Shape;

public class DrawingManagerImpl implements DrawingManager {


    @Override
    public void draw(Shape shape) {
        shape.draw(shape);
    }




}
