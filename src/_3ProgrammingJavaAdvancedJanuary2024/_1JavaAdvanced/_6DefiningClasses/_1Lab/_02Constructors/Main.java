package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._1Lab._02Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            if (carInfo.length == 1) {
                Car car = new Car(carInfo[0]);
                System.out.printf("%s", car.toString());
            } else {
                Car car = new Car(carInfo[0], carInfo[1], Integer.parseInt(carInfo[2]));
                System.out.printf("%s", car.toString());
            }
        }
    }
}
