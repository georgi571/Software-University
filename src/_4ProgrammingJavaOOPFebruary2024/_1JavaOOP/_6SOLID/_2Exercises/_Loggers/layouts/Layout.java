package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.layouts;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.enums.LogLevel;

public interface Layout {
    String format(String timeStamp, LogLevel level, String message);
}
