package _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.core;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.common.Command;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.factories.Factory;

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
            String result;
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
            case BuildFactory:
                result = buildFactory(data);
                break;
            case GetFactoryByName:
                result = String.valueOf(getFactoryByName(data));
                break;
            case BuildWorkshop:
                result = buildWorkshop(data);
                break;
            case AddWorkshopToFactory:
                result = addWorkshopToFactory(data);
                break;
            case ProduceFurniture:
                result = produceFurniture(data);
                break;
            case BuyWoodForFactory:
                result = buyWoodForFactory(data);
                break;
            case AddWoodToWorkshop:
                result = addWoodToWorkshop(data);
                break;
            case GetReport:
                result = getReport();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }

    private String buildFactory(String[] data) {
        return this.controller.buildFactory(data[0], data[1]);
    }

    private Factory getFactoryByName(String[] data) {
        return this.controller.getFactoryByName(data[0]);
    }

    private String buildWorkshop(String[] data) {
        return this.controller.buildWorkshop(data[0], Integer.parseInt(data[1]));
    }

    private String addWorkshopToFactory(String[] data) {
        return this.controller.addWorkshopToFactory(data[0], data[1]);
    }

    private String produceFurniture(String[] data) {
        return this.controller.produceFurniture(data[0]);
    }

    private String buyWoodForFactory(String[] data) {
        return this.controller.buyWoodForFactory(data[0]);
    }

    private String addWoodToWorkshop(String[] data) {
        return this.controller.addWoodToWorkshop(data[0], data[1], data[2]);
    }

    private String getReport() {
        return this.controller.getReport();
    }
}
