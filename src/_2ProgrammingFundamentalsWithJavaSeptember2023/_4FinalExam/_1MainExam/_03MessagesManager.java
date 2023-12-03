package _2ProgrammingFundamentalsWithJavaSeptember2023._4FinalExam._1MainExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> personSendInformation = new LinkedHashMap<>();
        Map<String, Integer> personReceiveInformation = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("Statistics")) {
            String[] commandParts = command.split("=");
            if (commandParts[0].equals("Add")) {
                String personName = commandParts[1];
                if (!personSendInformation.containsKey(personName)) {
                    int send = Integer.parseInt(commandParts[2]);
                    int received = Integer.parseInt(commandParts[3]);
                    personSendInformation.put(personName, send);
                    personReceiveInformation.put(personName, received);
                }
            } else if (commandParts[0].equals("Message")) {
                String sender = commandParts[1];
                String receiver = commandParts[2];
                if (personSendInformation.containsKey(sender) && personReceiveInformation.containsKey(receiver)) {
                    int sendCounter = personSendInformation.get(sender);
                    int receiveCounter = personReceiveInformation.get(sender);
                    int newSendCounter = sendCounter + 1;
                    int totalCount = newSendCounter + receiveCounter;
                    int send2Counter = personSendInformation.get(receiver);
                    int receive2Counter = personReceiveInformation.get(receiver);
                    int newReceiveCounter = receive2Counter + 1;
                    int total2Count = send2Counter + newReceiveCounter;
                    if (totalCount >= capacity) {
                        personSendInformation.remove(sender);
                        personReceiveInformation.remove(sender);
                        System.out.printf("%s reached the capacity!%n", sender);
                    } else {
                        personSendInformation.put(sender, newSendCounter);
                    }
                    if (total2Count >= capacity) {
                        personSendInformation.remove(receiver);
                        personReceiveInformation.remove(receiver);
                        System.out.printf("%s reached the capacity!%n", receiver);
                    } else {
                        personReceiveInformation.put(receiver, newReceiveCounter);
                    }
                }

            } else if (commandParts[0].equals("Empty")) {
                String currentCommand = commandParts[1];
                if (currentCommand.equals("All")) {
                    personSendInformation.clear();
                    personReceiveInformation.clear();
                } else {
                    if (personSendInformation.containsKey(currentCommand)) {
                        personSendInformation.remove(currentCommand);
                        personReceiveInformation.remove(currentCommand);
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Users count: %d%n", personSendInformation.size());
        personSendInformation.entrySet().forEach(entry -> {
            String currentName = entry.getKey();
            int counters = entry.getValue() + personReceiveInformation.get(currentName);
            System.out.printf("%s - %d%n", currentName, counters);
        });
    }
}
