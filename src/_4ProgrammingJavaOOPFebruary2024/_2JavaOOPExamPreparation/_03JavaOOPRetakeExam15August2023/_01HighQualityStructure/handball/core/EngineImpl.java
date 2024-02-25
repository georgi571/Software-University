package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._01HighQualityStructure.handball.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._01HighQualityStructure.handball.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
       // this.controller = new ControllerImpl(); //TODO implement first
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("Exit")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddGameplay:
                result = addGameplay(data);
                break;
            case AddTeam:
                result = addTeam(data);
                break;
            case AddEquipment:
                result = addEquipment(data);
                break;
            case EquipmentRequirement:
                result = equipmentRequirement(data);
                break;
            case PlayInGameplay:
                result = playInGameplay(data);
                break;
            case PercentAdvantage:
                result = percentAdvantage(data);
                break;
            case GetStatistics:
                result = getStatistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }

    private String addGameplay(String[] data) {
        // TODO
        return null;
    }

    private String addEquipment(String[] data) {
        // TODO
        return null;
    }

    private String equipmentRequirement(String[] data) {
        // TODO
        return null;
    }

    private String addTeam(String[] data) {
        // TODO
        return null;
    }

    private String playInGameplay(String[] data) {

        // TODO
        return null;
    }

    private String percentAdvantage(String[] data) {
        // TODO
        return null;
    }

    private String getStatistics() {
        return controller.getStatistics();
    }
}
