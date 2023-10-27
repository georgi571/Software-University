package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._2Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());
        int maxPassenger = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        while (!command.equals("end")){
            if (command.contains("Add")) {
                int count = Integer.parseInt(command.split(" ")[1]);
                wagons.add(count);
            } else {
                int passengerCount = Integer.parseInt(command);
                for (int i = 0; i <= wagons.size() - 1 ; i++) {
                    int passengerPerWagon = wagons.get(i);
                    if (passengerPerWagon + passengerCount <= maxPassenger) {
                        wagons.set(i, passengerCount + passengerPerWagon);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
