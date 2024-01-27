package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._17JavaAdvancedRetakeExam14April2021._03University.university;
public class Student {
    public String firstName;
    public String lastName;
    public String bestSubject;

    public Student(String firstName, String lastName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBestSubject() {
        return bestSubject;
    }

    public void setBestSubject(String bestSubject) {
        this.bestSubject = bestSubject;
    }

    @Override
    public String toString() {
        return String.format("Student: %s %s, %s",getFirstName(), getLastName(), getBestSubject());
    }
}
