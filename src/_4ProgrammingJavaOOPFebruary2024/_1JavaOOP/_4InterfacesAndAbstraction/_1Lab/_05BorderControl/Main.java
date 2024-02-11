package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._1Lab._05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Identifiable> entries = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandParts = command.split("\\s+");
            if (commandParts.length == 2) {
                Robot robot = new Robot(commandParts[0], commandParts[1]);
                entries.add(robot);
            } else {
                Citizen citizen = new Citizen(commandParts[0], Integer.parseInt(commandParts[1]), commandParts[2]);
                entries.add(citizen);
            }
            command = scanner.nextLine();
        }
        String lastDigits = scanner.nextLine();
        for (Identifiable entry : entries) {
            if (entry.getId().endsWith(lastDigits)) {
                System.out.printf("%s%n", entry.getId());
            }
        }
    }
}
