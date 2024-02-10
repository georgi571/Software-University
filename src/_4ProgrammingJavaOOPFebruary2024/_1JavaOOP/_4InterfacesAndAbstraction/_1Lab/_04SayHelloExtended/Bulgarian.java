package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._1Lab._04SayHelloExtended;

public class Bulgarian extends BasePerson {
    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return String.format("Здравей");
    }
}
