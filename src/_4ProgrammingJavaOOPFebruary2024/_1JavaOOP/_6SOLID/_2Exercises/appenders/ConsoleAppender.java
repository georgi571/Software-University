package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.appenders;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.enums.LogLevel;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.layouts.Layout;

public class ConsoleAppender extends BaseAppender {
    private Layout layout;

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String timeStamp, LogLevel level, String message) {
        counter++;
        System.out.printf("%s%n",getLayout().format(timeStamp, level, message));
    }
}
