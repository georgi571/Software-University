package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._2Encapsulation._2Exersices._01ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public double getLength() {
        return length;
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return 2 * getLength() * getWidth() + 2 * getLength() * getHeight() + 2 * getWidth() * getHeight();
    }

    public double calculateLateralSurfaceArea() {
        return 2 * getLength() * getHeight() + 2 * getWidth() * getHeight();
    }

    public double calculateVolume() {
        return getLength() * getWidth() * getHeight();
    }

    public void print() {
        System.out.printf("Surface Area - %.2f%n", calculateSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n", calculateLateralSurfaceArea());
        System.out.printf("Volume – %.2f%n", calculateVolume());
    }
}
