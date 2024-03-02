package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._01HighQualityStructure.zoo.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._01HighQualityStructure.zoo.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();
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
            case AddArea:
                result = addArea(data);
                break;
            case BuyFood:
                result = buyFood(data);
                break;
            case FoodForArea:
                result = foodForArea(data);
                break;
            case AddAnimal:
                result = addAnimal(data);
                break;
            case FeedAnimal:
                result = feedAnimal(data);
                break;
            case CalculateKg:
                result = calculateKg(data);
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
    private String addArea(String[] data) {
        //TODO
        return null;
    }

    private String buyFood(String[] data) {
        //TODO
        return null;
    }

    private String foodForArea(String[] data) {
        //TODO
        return null;
    }

    private String addAnimal(String[] data) {
        //TODO
        return null;
    }

    private String feedAnimal(String[] data) {
        //TODO
        return null;
    }

    private String calculateKg(String[] data) {
        //TODO
        return null;
    }

    private String getStatistics() {
        //TODO
        return null;
    }
}