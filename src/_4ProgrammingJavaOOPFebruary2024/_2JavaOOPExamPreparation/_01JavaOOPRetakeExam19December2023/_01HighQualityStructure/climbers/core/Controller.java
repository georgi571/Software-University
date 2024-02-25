package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._01HighQualityStructure.climbers.core;

public interface Controller {
    String addClimber(String type, String climberName);

    String addMountain(String mountainName, String... peaks);

    String removeClimber(String climberName);

    String startClimbing(String mountainName);

    String getStatistics();

}
