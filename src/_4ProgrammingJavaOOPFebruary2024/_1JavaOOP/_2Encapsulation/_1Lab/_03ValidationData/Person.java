package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._2Encapsulation._1Lab._03ValidationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private double increaseSalary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= 460.0) {
            throw new IllegalArgumentException("•Salary can't be less than 460.0");
        }
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
