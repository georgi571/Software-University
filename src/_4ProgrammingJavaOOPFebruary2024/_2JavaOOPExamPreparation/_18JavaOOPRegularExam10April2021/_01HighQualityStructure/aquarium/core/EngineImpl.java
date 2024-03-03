package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._01HighQualityStructure.aquarium.core;



import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021._01HighQualityStructure.aquarium.common.Command;

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
            case AddAquarium:
                result = addAquarium(data);
                break;
            case AddDecoration:
                result = addDecoration(data);
                break;
            case InsertDecoration:
                result = insertDecoration(data);
                break;
            case AddFish:
                result = addFish(data);
                break;
            case FeedFish:
                result = feedFish(data);
                break;
            case CalculateValue:
                result = calculateValue(data);
                break;
            case Report:
                result = report();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }
    private String addAquarium(String[] data) {
      //TODO
        return null;
    }

    private String addDecoration(String[] data) {
        //TODO
        return null;
    }

    private String insertDecoration(String[] data) {
        //TODO
        return null;
    }

    private String addFish(String[] data) {
        //{aquariumName} {fishType} {fishName} {fishSpecies} {price}
        //TODO
        return null;
    }

    private String feedFish(String[] data) {
        //TODO
        return null;
    }

    private String calculateValue(String[] data) {
        //TODO
        return null;
    }

    private String report() {
        return null;
    }
}

