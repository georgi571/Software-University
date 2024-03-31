package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.mission;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.explorers.Explorer;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        Collection<String> states = state.getExhibits();
        for (Explorer explorer : explorers) {
            while (explorer.canSearch() && states.iterator().hasNext()) {
                String currentState = states.iterator().next();
                explorer.search();
                explorer.getSuitcase().getExhibits().add(currentState);
                states.remove(currentState);
            }
        }
    }
}
