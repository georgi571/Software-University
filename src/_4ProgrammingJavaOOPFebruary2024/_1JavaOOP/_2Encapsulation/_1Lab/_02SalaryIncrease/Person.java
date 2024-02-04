package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._2Encapsulation._1Lab._02SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private double increaseSalary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getIncreaseSalary() {
        return increaseSalary;
    }

    public void setIncreaseSalary(double increaseSalary) {
        this.increaseSalary = increaseSalary;
    }

    public void increaseSalary(double bonus) {
        if (this.age >= 30) {
            this.salary += this.salary * bonus / 100;
        } else {
            this.salary += this.salary * (0.5 * bonus) / 100;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", getFirstName(), getLastName(), getSalary());
    }
}
