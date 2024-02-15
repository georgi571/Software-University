package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._01SingleResponsibility._01DrawingShape;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._01SingleResponsibility._01DrawingShape.interfaces.DrawingManager;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._01SingleResponsibility._01DrawingShape.interfaces.DrawingRepository;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._01SingleResponsibility._01DrawingShape.interfaces.Rengerer;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._01SingleResponsibility._01DrawingShape.interfaces.Shape;


public class DrawingManagerImpl implements DrawingManager {

    private final DrawingRepository drawingRepository;
    private final Rengerer renderer;

    public DrawingManagerImpl(DrawingRepository drawingRepository, Rengerer renderer) {
        this.drawingRepository = drawingRepository;
        this.renderer = renderer;
    }


    @Override
    public void draw(Shape shape) {
        shape.draw(this.renderer, this.drawingRepository);
    }
}
