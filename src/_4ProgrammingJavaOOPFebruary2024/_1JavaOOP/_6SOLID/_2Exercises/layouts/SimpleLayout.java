package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.layouts;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.enums.LogLevel;

public class SimpleLayout implements Layout{
    @Override
    public String format(String timeStamp, LogLevel level, String message) {
        return String.format("%s – %s – %s", timeStamp, level, message);
    }
}
