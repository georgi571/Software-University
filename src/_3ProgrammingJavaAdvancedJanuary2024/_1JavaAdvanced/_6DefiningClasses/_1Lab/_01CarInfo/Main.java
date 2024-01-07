package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._1Lab._01CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            car.setBrand(carInfo[0]);
            car.setModel(carInfo[1]);
            car.setHorsepower(Integer.parseInt(carInfo[2]));
            System.out.printf("%s", car.toString());
        }
    }
}
