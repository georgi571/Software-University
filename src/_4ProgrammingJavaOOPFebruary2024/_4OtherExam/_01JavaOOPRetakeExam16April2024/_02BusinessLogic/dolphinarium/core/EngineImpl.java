package _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.core;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.common.Command;

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
            case AddPool:
                result = addPool(data);
                break;
            case BuyFood:
                result = buyFood(data);
                break;
            case AddFoodToPool:
                result = addFoodToPool(data);
                break;
            case AddDolphin:
                result = addDolphin(data);
                break;
            case FeedDolphins:
                result = feedDolphins(data);
                break;
            case PlayWithDolphins:
                result = playWithDolphins(data);
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
    private String addPool(String[] data) {
        return this.controller.addPool(data[0], data[1]);
    }

    private String buyFood(String[] data) {
        return this.controller.buyFood(data[0]);
    }

    private String addFoodToPool(String[] data) {
        return this.controller.addFoodToPool(data[0], data[1]);
    }


    private String addDolphin(String[] data) {
        return this.controller.addDolphin(data[0], data[1], data[2], Integer.parseInt(data[3]));
    }

    private String feedDolphins(String[] data) {
        return this.controller.feedDolphins(data[0], data[1]);
    }

    private String playWithDolphins(String[] data) {
        return this.controller.playWithDolphins(data[0]);
    }


    private String getStatistics() {
        return this.controller.getStatistics();
    }
}