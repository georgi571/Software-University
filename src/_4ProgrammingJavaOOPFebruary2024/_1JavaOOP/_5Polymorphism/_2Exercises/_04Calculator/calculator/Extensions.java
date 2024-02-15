package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._5Polymorphism._2Exercises._04Calculator.calculator;

public class Extensions {
    private Extensions() {

    }
    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        return new ExtendedInterpreter(engine);
    }
}
