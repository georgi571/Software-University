package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._1Lab._04SayHelloExtended;

public abstract class BasePerson implements Person {
    private String name;

    protected BasePerson(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
