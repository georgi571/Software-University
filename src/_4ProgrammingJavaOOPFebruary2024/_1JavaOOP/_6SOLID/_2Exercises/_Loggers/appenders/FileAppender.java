package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.appenders;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.enums.LogLevel;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.layouts.Layout;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.utilites.File;

public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout, File file) {
        super(layout);
        this.file = file;
    }

    @Override
    public void append(String timeStamp, LogLevel logLevel, String message) {
        counter++;
        file.write(getLayout().format(timeStamp, logLevel, message));
    }

    public File getFile() {
        return file;
    }
}
