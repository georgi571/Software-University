package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._17JavaAdvancedRetakeExam14April2021._03University.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        String output = "";
        if (this.students.contains(student)) {
            output = String.format("Student is already in the university");
        } else {
            if (this.students.size() < capacity) {
                this.students.add(student);
                output = String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            } else {
                output = String.format("No seats in the university");
            }
        }
        return output;
    }

    public String dismissStudent(Student student) {
        String output = "";
        if (this.students.contains(student)) {
            this.students.remove(student);
            output = String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            output = String.format("Student not found");
        }
        return output;
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : this.students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student : this.students) {
            stringBuilder.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s%n", student.getFirstName(), student.getLastName(), student.getBestSubject()));
        }
        return stringBuilder.toString().trim();
    }
}
