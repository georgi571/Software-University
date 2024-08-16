package _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._01HighQualityStructure.forgottenBattleships.core;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._01HighQualityStructure.forgottenBattleships.common.Command;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._01HighQualityStructure.forgottenBattleships.entities.battlezone.BattleZone;

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
            case AddBattleZone:
                result = addBattleZone(data);
                break;
            case GetBattleZoneByName:
                result = String.valueOf(getBattleZoneByName(data));
                break;
            case AddBattleshipToBattleZone:
                result = addBattleshipToBattleZone(data);
                break;
            case StartBattle:
                result = startBattle(data);
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

    private String addBattleZone(String[] data) {
        return this.controller.addBattleZone(data[0], Integer.parseInt(data[1]));
    }

    private String addBattleshipToBattleZone(String[] data) {
        return this.controller.addBattleshipToBattleZone(data[0], data[1], data[2], Integer.parseInt(data[3]));
    }

    private BattleZone getBattleZoneByName(String[] data) {
        return this.controller.getBattleZoneByName(data[0]);
    }

    private String startBattle(String[] data) {
        return this.controller.startBattle(data[0], data[1], data[2]);
    }


    private String getStatistics() {
        return this.controller.getStatistics();
    }
}
