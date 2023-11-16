package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._2ProgrammingFundamentalsFinalExam;

import java.util.Scanner;

public class _01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stops = scanner.nextLine();
        StringBuilder finalsStops = new StringBuilder();
        finalsStops.append(stops);
        String command = scanner.nextLine();
        while (!command.equals("Travel")) {
            String[] commandParts = command.split(":");
            if (commandParts[0].equals("Add Stop")) {
                int index = Integer.parseInt(commandParts[1]);
                String newStop = commandParts[2];
                if (index >= 0 && index <= finalsStops.length() - 1){
                    finalsStops.insert(index, newStop);
                }
                System.out.printf("%s%n", finalsStops);
            } else if (commandParts[0].equals("Remove Stop")) {
                int startIndex = Integer.parseInt(commandParts[1]);
                int endIndex = Integer.parseInt(commandParts[2]);
                if (startIndex >= 0 && startIndex <= finalsStops.length() - 1 && endIndex >= 0 && endIndex <= finalsStops.length() - 1) {
                    finalsStops.delete(startIndex, endIndex + 1 );
                }
                System.out.printf("%s%n", finalsStops);
            } else if (commandParts[0].equals("Switch")) {
                String oldStop = commandParts[1];
                String newStop = commandParts[2];
                Integer firstIndex = finalsStops.indexOf(oldStop);
                if (finalsStops.toString().contains(oldStop)) {
                    finalsStops.replace(firstIndex, firstIndex + oldStop.length(), newStop);
                }
                System.out.printf("%s%n", finalsStops);
            }
            command = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", finalsStops);
    }
}
