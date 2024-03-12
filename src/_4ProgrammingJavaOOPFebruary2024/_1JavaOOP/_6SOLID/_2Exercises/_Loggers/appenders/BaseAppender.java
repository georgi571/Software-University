package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.appenders;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.layouts.Layout;

public abstract class BaseAppender implements Appender {
    private Layout layout;
    protected int counter;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
    }

    @Override
    public Layout getLayout() {
        return layout;
    }

    @Override
    public int getMessagesCount() {
        return counter;
    }
}
