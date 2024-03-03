package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._01HighQualityStructure.aquarium.core;

public interface Controller {

    String addAquarium(String aquariumType, String aquariumName);
    String addDecoration(String type);
    String insertDecoration(String aquariumName, String decorationType);
    String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price);
    String feedFish(String aquariumName);
    String calculateValue(String aquariumName);
    String report();
}
