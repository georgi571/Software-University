package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._1Lab._06Student2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<Student> studentList = new ArrayList<>();
        while (!command.equals("end")) {
            String[] studentData = command.split(" ");
            String firstName = studentData[0];
            String lastName = studentData[1];
            int age = Integer.parseInt(studentData[2]);
            String city = studentData[3];
            if (isStudentExisting(studentList, firstName,lastName)) {
                Student student = getStudent(studentList, firstName, lastName);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHometown(city);
            } else {
                Student student = new Student(firstName, lastName, age, city);
                studentList.add(student);
            }
            command = scanner.nextLine();
        }
        String cityName = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getHometown().equals(cityName)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
    private static boolean isStudentExisting (List<Student> studentList, String firstName, String lastName) {
        for (Student student : studentList) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }
    private static Student getStudent(List<Student> studentList, String firstName, String lastName) {
        Student existingStudent = null;
        for (Student student : studentList) {
           if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }
        return existingStudent;
    }
}
