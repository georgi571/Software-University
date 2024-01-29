package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._1WorkingWithAbstraction._1Lab._03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    public void executeCommand(String[] commandParts) {
        String commandName = commandParts[0];
        if (commandName.equals("Create")) {
            createStudent(commandParts);
        } else if (commandName.equals("Show")) {
            showStudent(commandParts);
        }
    }

    private void showStudent(String[] commandParts) {
        String name = commandParts[1];
        if (students.containsKey(name)) {
            Student student = students.get(name);
            StringBuilder output = new StringBuilder();
            output.append(String.format("%s",student.toString()));
            if (student.getGrade() >= 5.00) {
                output.append(String.format(" Excellent student."));
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                output.append(String.format(" Average student."));
            } else {
                output.append(String.format(" Very nice person."));
            }
            System.out.printf("%s%n", output);
        }
    }

    private void createStudent(String[] commandParts) {
        String name = commandParts[1];
        int age = Integer.parseInt(commandParts[2]);
        double grade = Double.parseDouble(commandParts[3]);
        Student student = new Student(name, age, grade);
        students.putIfAbsent(name, student);
    }
}
