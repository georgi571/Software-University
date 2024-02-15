package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._05DependencyInversion._02Worker;

public class Manager {

    public Manager() {
        Worker worker = new Worker();
        worker.work();
    }
}
