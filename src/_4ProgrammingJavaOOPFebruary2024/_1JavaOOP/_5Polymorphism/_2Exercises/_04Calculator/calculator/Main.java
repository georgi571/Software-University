package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._5Polymorphism._2Exercises._04Calculator.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CalculationEngine engine = new CalculationEngine();
        InputInterpreter interpreter = Extensions.buildInterpreter(engine);
        String[] tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            if(token.equals("end")){
                break;
            }
            interpreter.interpret(token);
        }

        System.out.println(engine.getCurrentResult());
    }
}
