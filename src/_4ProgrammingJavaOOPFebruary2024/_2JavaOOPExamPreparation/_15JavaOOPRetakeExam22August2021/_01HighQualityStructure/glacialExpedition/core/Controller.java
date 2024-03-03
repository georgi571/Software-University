package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._01HighQualityStructure.glacialExpedition.core;

public interface Controller {
    String addExplorer(String type, String explorerName);

    String addState(String stateName, String... exhibits);

    String retireExplorer(String explorerName);

    String exploreState(String stateName);

    String finalResult();
}
