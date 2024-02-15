package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._05DependencyInversion._01HelloWord;

import java.time.LocalDateTime;

public class HelloWorld {
    public String greeting(String name) {
        if (LocalDateTime.now().getHour()< 12) {
            return "Good morning, " + name;
        }

        if (LocalDateTime.now().getHour() < 18) {
            return "Good afternoon, " + name;
        }

        return "Good evening, " + name;
    }
}
