package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.loggers;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.appenders.Appender;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.appenders.FileAppender;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.enums.LogLevel;

import java.util.Map;

public class MessageLogger implements Logger {
    private Map<Appender, LogLevel> appendersWithLevels;

    public MessageLogger(Map<Appender, LogLevel> appendersWithLevels) {
        this.appendersWithLevels = appendersWithLevels;
    }

    @Override
    public void logInfo(String timeStamp, String message) {
        logToAll(timeStamp, LogLevel.INFO, message);
    }

    @Override
    public void logWarning(String timeStamp, String message) {
        logToAll(timeStamp, LogLevel.WARNING, message);
    }

    @Override
    public void logError(String timeStamp, String message) {
        logToAll(timeStamp, LogLevel.ERROR, message);
    }

    @Override
    public void logCritical(String timeStamp, String message) {
        logToAll(timeStamp, LogLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String timeStamp, String message) {
        logToAll(timeStamp, LogLevel.FATAL, message);
    }

    private void logToAll(String timeStamp, LogLevel logLevel, String message) {
        for (Map.Entry<Appender, LogLevel> entry : appendersWithLevels.entrySet()) {
            Appender appender = entry.getKey();
            LogLevel appenderLevel = entry.getValue();
            if (appenderLevel.ordinal() <= logLevel.ordinal())
                appender.append(timeStamp, logLevel, message);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Logger info");
        stringBuilder.append(System.lineSeparator());
        for (Map.Entry<Appender, LogLevel> entry : appendersWithLevels.entrySet()) {
            Appender appender = entry.getKey();
            LogLevel logLevel = entry.getValue();
            stringBuilder.append(String.format("Appender type: %s, Layout type: %s, ",
                            appender.getClass().getSimpleName(), appender.getLayout().getClass().getSimpleName()))
                    .append(String.format("Report level: %s, ", logLevel.toString()))
                    .append(String.format("Messages appended: %d", appender.getMessagesCount()));
            if (appender instanceof FileAppender) {
                stringBuilder.append(String.format(", File size: %d", ((FileAppender)appender).getFile().size()));
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
