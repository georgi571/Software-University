package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl(); //TODO implement first
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("End")) {
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
            case AddService:
                result = addService(data);
                break;
            case AddSupplement:
                result = addSupplement(data);
                break;
            case SupplementForService:
                result = supplementForService(data);
                break;
            case AddRobot:
                result = addRobot(data);
                break;
            case FeedingRobot:
                result = feedingRobot(data);
                break;
            case SumOfAll:
                result = sumOfAll(data);
                break;
            case Statistics:
                result = getStatistics();
                break;
            case End:
                result = Command.End.name();
                break;
        }
        return result;
    }

    private String addService(String[] data) {
        // TODO
        return null;
    }
    private String addSupplement(String[] data) {
        // TODO
        return null;
    }

    private String supplementForService(String[] data) {
        // TODO
        return null;
    }

    private String addRobot(String[] data) {
        // TODO
        return null;
    }

    private String feedingRobot(String[] data) {
        // TODO
        return null;
    }

    private String sumOfAll(String[] data) {
        // TODO
        return null;
    }

    private String getStatistics() {
        return this.controller.getStatistics();
    }
}