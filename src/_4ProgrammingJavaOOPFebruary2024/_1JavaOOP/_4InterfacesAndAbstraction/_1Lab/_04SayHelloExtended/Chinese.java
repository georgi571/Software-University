package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._1Lab._04SayHelloExtended;

public class Chinese extends BasePerson {
    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return String.format("Djydjybydjy");
    }

}
