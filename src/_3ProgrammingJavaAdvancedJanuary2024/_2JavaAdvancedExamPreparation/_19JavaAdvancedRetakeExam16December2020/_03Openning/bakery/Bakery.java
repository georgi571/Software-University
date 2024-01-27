package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._19JavaAdvancedRetakeExam16December2020._03Openning.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees ;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return this.employees.remove(employee);
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        Employee oldestEmployee = null;
        for (Employee employee : this.employees) {
            if (oldestEmployee == null) {
                oldestEmployee = employee;
            } else {
                if (employee.getAge() > oldestEmployee.getAge()) {
                    oldestEmployee = employee;
                }
            }
        }
        return oldestEmployee;
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
        stringBuilder.append(String.format("Employees working at Bakery %s:%n",this.name)).trimToSize();
        for (Employee employee : this.employees) {
            stringBuilder.append(String.format("%s%n", employee.toString()));
        }
        return stringBuilder.toString().trim();
    }
}
