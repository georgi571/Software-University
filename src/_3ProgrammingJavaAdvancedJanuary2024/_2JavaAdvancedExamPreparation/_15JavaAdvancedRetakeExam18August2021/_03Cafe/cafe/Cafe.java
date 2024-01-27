package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._15JavaAdvancedRetakeExam18August2021._03Cafe.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return this.employees.remove(employee);
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        Employee getOldestEmployee = null;
        for (Employee employee : this.employees) {
            if (getOldestEmployee == null) {
                getOldestEmployee = employee;
            } else {
                if (employee.getAge() > getOldestEmployee.getAge()) {
                    getOldestEmployee = employee;
                }
            }
        }
        return getOldestEmployee;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Employees working at Cafe %s:%n",this.name)).trimToSize();
        for (Employee employee : this.employees) {
            stringBuilder.append(String.format("%s%n",employee.toString()));
        }
        return stringBuilder.toString().trim();
    }
}
