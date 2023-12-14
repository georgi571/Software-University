package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._1Lab;

import java.util.*;

public class _05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> students = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] studentInfo = scanner.nextLine().split("\\s+");
            if (students.containsKey(studentInfo[0])) {
                students.get(studentInfo[0]).add(Double.parseDouble(studentInfo[1]));
            } else {
                List<Double> grades = new ArrayList<>();
                grades.add(Double.parseDouble(studentInfo[1]));
                students.put(studentInfo[0], grades);
            }
        }
        students.entrySet().forEach(entry -> {
            System.out.printf("%s -> ",entry.getKey());
            double grades = 0;
            int counter = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                grades += entry.getValue().get(i);
                counter++;
                System.out.printf("%.2f ",entry.getValue().get(i));
            }
            double averageGrade = grades / counter;
            System.out.printf("(avg: %.2f)%n",averageGrade);
            ;
        });
    }
}
