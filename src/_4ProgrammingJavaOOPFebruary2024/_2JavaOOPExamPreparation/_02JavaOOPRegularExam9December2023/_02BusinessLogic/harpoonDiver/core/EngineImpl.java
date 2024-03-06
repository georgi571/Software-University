package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.common.Command;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class EngineImpl implements Engine {
    private final Controller controller;
    private final Scanner scanner;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }



    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }

    }

    private String processInput() throws IOException {
        String input = this.scanner.nextLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddDiver:
                result = addDiver(data);
                break;
            case AddDivingSite:
                result = addDivingSite(data);
                break;
            case RemoveDiver:
                result = removeDiver(data);
                break;
            case StartDiving:
                result = startDiving(data);
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


    private String addDiver(String[] data) {
        return this.controller.addDiver(data[0], data[1]);
    }
    private String addDivingSite(String[] data) {
        String siteName = data[0];
        String[] seaCreature = Arrays.stream(data).skip(1).toArray(String[]::new);
        return this.controller.addDivingSite(siteName, seaCreature);
    }
    private String removeDiver(String[] data) {
        return this.controller.removeDiver(data[0]);
    }


    private String startDiving(String[] data) {
        return this.controller.startDiving(data[0]);
    }
    private String getStatistics() {
        return this.controller.getStatistics();
    }



}
