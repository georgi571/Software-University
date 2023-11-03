package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._07AssociativeArrays._2Exercise;

import java.util.*;

public class _06StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGrade = new LinkedHashMap<>();
        for (int i = 1; i <= n ; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if (!studentsGrade.containsKey(name)){
                studentsGrade.put(name, new ArrayList<>());
                studentsGrade.get(name).add(grade);
            } else {
                List<Double> currentGrades = studentsGrade.get(name);
                currentGrades.add(grade);
            }
        }
        Map<String, Double> studentAverageGrade = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : studentsGrade.entrySet()){
            String studentName = entry.getKey();
            List<Double> grades = entry.getValue();
            double average = getAverageGrade(grades);
            if (average >= 4.50) {
                studentAverageGrade.put(studentName, average);
            }
        }
        studentAverageGrade.entrySet().forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));
    }
    private static double getAverageGrade(List<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
