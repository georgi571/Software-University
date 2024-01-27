package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._07JavaAdvancedRetakeExam14December2022._03SoftUnisStudents.softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public String insert(Student student) {
        String output = "";
        if (this.data.size() < capacity) {
            if (!this.data.contains(student)) {
                this.data.add(student);
                output = String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
            } else {
                output = String.format("Student is already in the hall.");
            }
        }  else {
            output = String.format("The hall is full.");
        }
        return output;
    }

    public String remove(Student student) {
        String output = "";
        if (this.data.contains(student)) {
            this.data.remove(student);
            output = String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        } else {
            output = String.format("Student not found.");
        }
        return output;
    }
    public Student getStudent(String firstName, String lastName) {
        for (Student datum : this.data) {
            if (datum.getFirstName().equals(firstName) && datum.getLastName().equals(lastName)) {
                return datum;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Hall size: %d%n", this.data.size()));
        for (Student datum : this.data) {
            stringBuilder.append(String.format("%s%n", datum.toString()));
        }
        return stringBuilder.toString();
    }
}
