package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.appenders;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.enums.LogLevel;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.layouts.Layout;

public interface Appender {
    void append(String timeStamp, LogLevel level, String message);
    Layout getLayout();
    int getMessagesCount();
}
