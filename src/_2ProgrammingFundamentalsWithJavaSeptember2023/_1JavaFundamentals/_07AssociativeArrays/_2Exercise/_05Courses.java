package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._07AssociativeArrays._2Exercise;

import java.util.*;

public class _05Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] input = command.split(" : ");
            String course = input[0];
            String student = input[1];
            if (!courses.containsKey(course)) {
                courses.put(course, new ArrayList<>());
                courses.get(course).add(student);
            } else {
                courses.get(course).add(student);
            }
            command = scanner.nextLine();
        }
        courses.entrySet().forEach(entry -> {
            int number = entry.getValue().size();
            System.out.printf("%s: %d%n",entry.getKey(), number);
            entry.getValue().forEach(student -> System.out.printf("-- %s%n", student));
        });
    }
}
