package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._02OpenClosedPrinciple._01FileStream;

public class File {
    private String name;

    private int length;

    private int sent;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSent() {
        return this.sent;
    }

    public void setSent(int sent) {
        this.sent = sent;
    }
}
