package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._1Lab._06Ferrari;

public class Ferrari implements Car {
    private static final String MODEL = "488-Spider";
    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = MODEL;
    }

    @Override
    public String brakes() {
        return String.format("Brakes!");
    }

    @Override
    public String gas() {
        return String.format("brum-brum-brum-brrrrr");
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",this.model, this.brakes(), this.gas(), this.driverName);
    }
}
