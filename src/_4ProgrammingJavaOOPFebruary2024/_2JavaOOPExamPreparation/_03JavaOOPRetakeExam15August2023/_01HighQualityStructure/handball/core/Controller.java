package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._01HighQualityStructure.handball.core;

public interface Controller {
    String addGameplay(String gameplayType, String gameplayName);
    String addEquipment(String equipmentType);
    String equipmentRequirement(String gameplayName, String equipmentType);
    String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage);
    String playInGameplay(String gameplayName);
    public String percentAdvantage(String gameplayName);
    String getStatistics();



}
