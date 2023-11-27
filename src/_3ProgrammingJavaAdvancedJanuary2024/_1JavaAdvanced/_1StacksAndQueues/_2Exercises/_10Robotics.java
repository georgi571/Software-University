package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._2Exercises;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robotInfo = scanner.nextLine().split(";");
        List<String> robotName = new ArrayList<>();
        List<Integer> robotTime = new ArrayList<>();
        List<Integer> robotNextUsingTime = new ArrayList<>();
        ArrayDeque<String> que = new ArrayDeque<>();
        for (int i = 0; i < robotInfo.length; i++) {
            String[] robotInfoParts = robotInfo[i].split("-");
            robotName.add(robotInfoParts[0]);
            robotTime.add(Integer.parseInt(robotInfoParts[1]));
        }
        String[] startTime = scanner.nextLine().split(":");
        int hours = Integer.parseInt(startTime[0]);
        int minutes = Integer.parseInt(startTime[1]);
        int seconds = Integer.parseInt(startTime[2]);
        int timing = ((hours * 60)*60)+(minutes*60)+seconds;
        for (int i = 0; i < robotName.size(); i++) {
            robotNextUsingTime.add(timing);
        }
        int newHours = hours;
        int newMinutes = minutes;
        int newSeconds = seconds;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            que.offer(command);
            command = scanner.nextLine();
        }
        while (!que.isEmpty()) {
            boolean isItemGetByRobot = false;
            timing++;
            newSeconds++;
            if (newSeconds == 60) {
                newSeconds = 0;
                newMinutes++;
                if (newMinutes == 60) {
                    newMinutes = 0;
                    newHours++;
                    if (newHours == 24) {
                        newHours = 0;
                    }
                }
            }
            for (int i = 0; i < robotNextUsingTime.size(); i++) {
                if (robotNextUsingTime.get(i) <= timing) {
                    robotNextUsingTime.set(i, timing + robotTime.get(i));
                    System.out.printf("%s - %s [%02d:%02d:%02d]%n", robotName.get(i), que.poll(), newHours, newMinutes, newSeconds);
                    isItemGetByRobot = true;
                    break;
                }
            }
            if (!isItemGetByRobot) {
                que.offer(que.poll());
            }
        }
    }
}
