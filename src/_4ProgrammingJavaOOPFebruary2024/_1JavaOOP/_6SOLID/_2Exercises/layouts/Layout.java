package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.layouts;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.enums.LogLevel;

public interface Layout {
    String format(String timeStamp, LogLevel level, String message);
}
