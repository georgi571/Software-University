package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._3MoreExercise._01CompanyRoster;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Department departments = new Department(n);
        for (int i = 0; i < n; i++) {
            String[] employer = scanner.nextLine().split(" ");
            String name = employer[0];
            double salary = Double.parseDouble(employer[1]);
            String position = employer[2];
            String department = employer[3];
            String email = "n/a";
            int age = -1;
            if (employer.length == 5) {
                if (employer[4].contains("@")) {
                    email = employer[4];
                } else {
                    age = Integer.parseInt(employer[4]);
                }
            } else if (employer.length == 6){
                email = employer[4];
                age = Integer.parseInt(employer[5]);
            } else {
            }
            Employee employee = new Employee(name, salary, position, department, email, age);
            departments.add(employee);
        }
        System.out.println(departments.getInfo());
    }
}
