package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.appenders;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.enums.LogLevel;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises.layouts.Layout;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class XmlAppender extends BaseAppender {
    public XmlAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String timeStamp, LogLevel logLevel, String message) {
        try {
            File file = new File("logs.xml");
            if (!file.exists()) {
                file.createNewFile();
            }
            Files.writeString(Path.of("logs.xml"),
                    getLayout().format(timeStamp, logLevel, message), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
