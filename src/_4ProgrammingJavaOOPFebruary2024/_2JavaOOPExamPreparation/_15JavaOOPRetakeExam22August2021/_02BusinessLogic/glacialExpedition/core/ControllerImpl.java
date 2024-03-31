package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.explorers.AnimalExplorer;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.explorers.Explorer;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.explorers.GlacierExplorer;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.explorers.NaturalExplorer;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.mission.Mission;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.mission.MissionImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.states.State;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.models.states.StateImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.repositories.ExplorerRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.repositories.Repository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._02BusinessLogic.glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Explorer> explorerRepository;
    private Repository<State> stateRepository;
    int count;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.count = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        if (type.equals("AnimalExplorer")) {
            explorer = new AnimalExplorer(explorerName);
        } else if (type.equals("GlacierExplorer")) {
            explorer = new GlacierExplorer(explorerName);
        } else if (type.equals("NaturalExplorer")) {
            explorer = new NaturalExplorer(explorerName);
        } else {
            throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        this.explorerRepository.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }
        this.stateRepository.add(state);
        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = this.explorerRepository.byName(explorerName);
        if (explorer == null) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        this.explorerRepository.remove(explorer);
        return String.format(EXPLORER_RETIRED,explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        State state = this.stateRepository.byName(stateName);
        List<Explorer> explorers = this.explorerRepository.getCollection().stream().filter(explorer -> explorer.getEnergy() > 50).collect(Collectors.toList());
        if (explorers.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();
        mission.explore(state, explorers);
        this.count++;
        long retiredExplorers = explorers.stream().filter(Explorer::canSearch).count();
        return String.format(STATE_EXPLORER, stateName, explorers.size() - retiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(FINAL_STATE_EXPLORED, this.count)).append(System.lineSeparator());
        result.append(FINAL_EXPLORER_INFO).append(System.lineSeparator());
        for (Explorer explorer : this.explorerRepository.getCollection()) {
            result.append(String.format(FINAL_EXPLORER_NAME, explorer.getName())).append(System.lineSeparator());
            result.append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy())).append(System.lineSeparator());
            if (explorer.getSuitcase().getExhibits().isEmpty()) {
                result.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, "None")).append(System.lineSeparator());
            } else {
                result.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits()))).append(System.lineSeparator());
            }
        }
        return result.toString().trim();
    }
}
