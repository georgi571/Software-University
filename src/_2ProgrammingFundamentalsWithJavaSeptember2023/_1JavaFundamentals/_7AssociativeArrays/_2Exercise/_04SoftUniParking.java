package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._7AssociativeArrays._2Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> carOwner = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n ; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String username = input[1];
            if (command.equals("register")) {
                String licensePlateNumber = input[2];
                if (!carOwner.containsKey(username)){
                    carOwner.put(username, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n", username,licensePlateNumber);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", carOwner.get(username));
                }

            } else if (command.equals("unregister")) {
                if (carOwner.containsKey(username)) {
                    carOwner.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                } else {
                    System.out.printf("ERROR: user %s not found%n",username);
                }

            }
        }
        carOwner.entrySet().forEach(entry -> System.out.printf("%s => %s%n", entry.getKey(), entry.getValue()));
    }
}
