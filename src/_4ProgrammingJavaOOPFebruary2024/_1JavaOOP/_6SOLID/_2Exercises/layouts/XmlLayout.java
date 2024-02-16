package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.layouts;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.enums.LogLevel;

public class XmlLayout implements Layout {
    @Override
    public String format(String timeStamp, LogLevel level, String message) {
        return String.format("<log>%n<date>%s</date>%n<level>%s</level>%n<message>%s</message>%n</log>%n", timeStamp, level, message);
    }
}
