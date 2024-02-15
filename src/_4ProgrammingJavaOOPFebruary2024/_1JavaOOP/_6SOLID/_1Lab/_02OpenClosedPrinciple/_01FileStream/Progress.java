package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._02OpenClosedPrinciple._01FileStream;

public class Progress {
    private final File file;

    public Progress(File file)
    {
        this.file = file;
    }

    public int getCurrentPercent()
    {
        return this.file.getSent() * 100 / this.file.getLength();
    }
}
