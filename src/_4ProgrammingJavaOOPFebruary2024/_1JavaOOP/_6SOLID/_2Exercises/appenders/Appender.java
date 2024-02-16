package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.appenders;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.enums.LogLevel;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.layouts.Layout;

public interface Appender {
    void append(String timeStamp, LogLevel level, String message);
    Layout getLayout();
    int getMessagesCount();
}
