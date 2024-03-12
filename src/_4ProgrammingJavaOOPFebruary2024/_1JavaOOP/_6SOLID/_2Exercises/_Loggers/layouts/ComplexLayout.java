package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.layouts;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.enums.LogLevel;

public class ComplexLayout implements Layout {
    @Override
    public String format(String timestamp, LogLevel logLevel, String message) {
        return String.format("%s <=> %s <=> %s", timestamp, logLevel, message);
    }
}
