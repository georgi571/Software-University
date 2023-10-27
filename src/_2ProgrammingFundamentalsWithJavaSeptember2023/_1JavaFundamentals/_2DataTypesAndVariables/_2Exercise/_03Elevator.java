package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._2DataTypesAndVariables._2Exercise;

import java.util.Scanner;

public class _03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int capacityPofPerson = Integer.parseInt(scanner.nextLine());
        int courses = (int) Math.ceil((double) numberOfPeople /capacityPofPerson);
        System.out.printf("%d",courses);
    }
}
