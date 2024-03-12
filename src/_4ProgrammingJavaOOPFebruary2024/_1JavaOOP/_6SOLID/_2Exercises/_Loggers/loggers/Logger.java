package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._2Exercises._Loggers.loggers;

public interface Logger {
    //Info > Warning > Error > Critical > Fatal.
    void logInfo(String timeStamp, String message);
    void logWarning(String timeStamp, String message);
    void logError(String timeStamp, String message);
    void logCritical(String timeStamp, String message);
    void logFatal(String timeStamp, String message);
}
