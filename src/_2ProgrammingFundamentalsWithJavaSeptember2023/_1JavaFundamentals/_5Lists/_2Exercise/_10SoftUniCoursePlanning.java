package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._2Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> courses = Arrays.stream(scanner.nextLine()
                                .split(", "))
                        .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("course start")) {
            String[] input = command.split(":");
            String commandToModify = input[0];
            String lessonTitle = input[1];
            String exercise = lessonTitle + "-Exercise";
            if (commandToModify.equals("Add")) {
                if (!courses.contains(lessonTitle)) {
                    courses.add(lessonTitle);
                }
            } else if (commandToModify.equals("Insert")) {
                int index = Integer.parseInt(input[2]);
                if (!courses.contains(lessonTitle)) {
                    courses.add(index, lessonTitle);
                }
            } else if (commandToModify.equals("Remove")) {
                if (courses.contains(lessonTitle)) {
                    courses.remove(lessonTitle);
                }
            } else if (commandToModify.equals("Swap")) {
                String lessonTitle2 = input[2];
                String exercise2 = lessonTitle2 + "-Exercise";
                if (courses.contains(lessonTitle) && courses.contains(lessonTitle2)) {
                    int indexLesson1 = courses.indexOf(lessonTitle);
                    int indexLesson2 = courses.indexOf(lessonTitle2);
                    courses.remove(indexLesson1);
                    courses.add(indexLesson1, lessonTitle2);
                    courses.remove(indexLesson2);
                    courses.add(indexLesson2, lessonTitle);
                    if (courses.contains(exercise)) {
                        courses.remove(exercise);
                        int indexOfExercise = courses.indexOf(lessonTitle) + 1;
                        courses.add(indexOfExercise, exercise);
                    }
                    if (courses.contains(exercise2)) {
                        courses.remove(exercise2);
                        int indexOfExercise2 = courses.indexOf(lessonTitle2) + 1;
                        courses.add(indexOfExercise2, exercise2);
                    }
                }
            } else if (commandToModify.equals("Exercise")) {
                if (courses.contains(lessonTitle)) {
                    if (!courses.contains(exercise)) {
                        int getIndex = courses.indexOf(lessonTitle);
                        courses.add(getIndex + 1, exercise);
                    }
                } else {
                    courses.add(lessonTitle);
                    courses.add(exercise);
                }
            }
            command = scanner.nextLine();
        }
        int number = 1;
        for (int i = 0; i <= courses.size() - 1; i++) {
            System.out.printf("%d.%s%n", number, courses.get(i));
            number++;
        }
    }
}
