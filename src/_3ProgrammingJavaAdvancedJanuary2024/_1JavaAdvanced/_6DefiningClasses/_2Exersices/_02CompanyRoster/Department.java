package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._2Exersices._02CompanyRoster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Department {
    private List<Employee> departmentInfo;
    private int n;
    public Department(int n) {
        this.n = n;
        this.departmentInfo = new ArrayList<>();
    }
    public void add(Employee employee){
        if (departmentInfo.size() <= n) {
            departmentInfo.add(employee);
        }
    }
    private String getHighestAverageSalaryDeparment () {
        String highestDepartment = "";
        double highestAverageSalary = 0.0;
        for (Employee employee : this.departmentInfo) {
            String departmentName = employee.getDepartment();
            double totalSalary = 0.0;
            int numberOfEmployers = 0;
            for (Employee employer : this.departmentInfo) {
                if (departmentName.equals(employer.getDepartment())) {
                    totalSalary += employer.getSalary();
                    numberOfEmployers++;
                }
            }
            double averageSalary = totalSalary / numberOfEmployers;
            if (averageSalary > highestAverageSalary) {
                highestDepartment = departmentName;
                highestAverageSalary = averageSalary;
            }
        }
        return highestDepartment;
    }
    private double getHighestAverageSalary () {
        String highestDepartment = "";
        double highestAverageSalary = 0.0;
        for (Employee employee : this.departmentInfo) {
            String departmentName = employee.getDepartment();
            double totalSalary = 0.0;
            int numberOfEmployers = 0;
            for (Employee employer : this.departmentInfo) {
                if (departmentName.equals(employer.getDepartment())) {
                    totalSalary += employer.getSalary();
                    numberOfEmployers++;
                }
            }
            double averageSalary = totalSalary / numberOfEmployers;
            if (averageSalary > highestAverageSalary) {
                highestDepartment = departmentName;
                highestAverageSalary = averageSalary;
            }
        }
        return highestAverageSalary;
    }
    public String getInfo () {
        String name = getHighestAverageSalaryDeparment();
        double averageSalary = getHighestAverageSalary();
        String output = "";
        output += String.format("Highest Average Salary: %s%n", name);
        Collections.sort(departmentInfo, Comparator.comparingDouble(Employee::getSalary).reversed());
        for (Employee employee : this.departmentInfo) {
            if (employee.getDepartment().equals(name)) {
                output += String.format("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
            }
        }
        return output;
    }
}
