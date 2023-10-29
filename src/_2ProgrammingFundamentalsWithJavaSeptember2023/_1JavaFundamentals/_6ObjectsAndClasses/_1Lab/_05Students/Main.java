package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._1Lab._05Students;

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
            Student student = new Student(firstName, lastName, age, city);
            studentList.add(student);
            command = scanner.nextLine();
        }
        String cityName = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getHometown().equals(cityName)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
