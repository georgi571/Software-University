package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._1Lab;

import java.util.Scanner;

public class _07ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int countProjects =Integer.parseInt(scanner.nextLine());
        int hourForOneProject = 3;
        int totalHours = countProjects * hourForOneProject;
        System.out.println("The architect " + name + " will need " + totalHours + " hours to complete " + countProjects + " project/s.");
    }
}
