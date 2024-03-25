package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._01HighQualityStructure.goldDigger.models.operation;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._01HighQualityStructure.goldDigger.models.discoverer.Discoverer;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._01HighQualityStructure.goldDigger.models.spot.Spot;

import java.util.Collection;

public class OperationImpl implements Operation{
    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        Collection<String> spots  = spot.getExhibits();
        for (Discoverer discoverer : discoverers) {
            while (discoverer.canDig() && spots.iterator().hasNext()) {
                discoverer.dig();
                String currentSpot = spots.iterator().next();
                discoverer.getMuseum().getExhibits().add(currentSpot);
                spots.remove(currentSpot);
            }
        }
    }
}
