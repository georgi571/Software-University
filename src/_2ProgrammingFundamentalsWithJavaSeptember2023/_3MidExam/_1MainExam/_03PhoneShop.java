package _2ProgrammingFundamentalsWithJavaSeptember2023._3MidExam._1MainExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03PhoneShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> phones = Arrays.stream(scanner.nextLine()
                                .split(", "))
                        .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] currentCommand = command.split(" - ");
            String receivedCommand = currentCommand[0];
            String receivedPhone = currentCommand[1];
            if (receivedCommand.equals("Add")) {
                if (!phones.contains(receivedPhone)) {
                    phones.add(receivedPhone);
                }
            } else if (receivedCommand.equals("Remove")) {
                if (phones.contains(receivedPhone)) {
                    int indexOfPhone = phones.indexOf(receivedPhone);
                    phones.remove(indexOfPhone);
                }
            } else if (receivedCommand.equals("Bonus phone")) {
                String[] checkPhones = receivedPhone.split(":");
                String oldPhone = checkPhones[0];
                String newPhone = checkPhones[1];
                if (phones.contains(oldPhone)) {
                    int indexOfOldPhone = phones.indexOf(oldPhone);
                    phones.add(indexOfOldPhone + 1, newPhone);
                }
            } else if (receivedCommand.equals("Last")) {
                if (phones.contains(receivedPhone)) {
                    int indexOfPhone = phones.indexOf(receivedPhone);
                    phones.remove(indexOfPhone);
                    phones.add(receivedPhone);
                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < phones.size() - 1; i++) {
            System.out.printf("%s, ", phones.get(i));
        }
        System.out.printf("%s", phones.get(phones.size() - 1));
    }
}
