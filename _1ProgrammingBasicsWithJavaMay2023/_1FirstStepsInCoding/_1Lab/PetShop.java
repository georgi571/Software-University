package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._1Lab;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countDog = Integer.parseInt(scanner.nextLine());
        int countCat = Integer.parseInt(scanner.nextLine());
        double onePackDog = 2.5;
        double onePackCat = 4;
        double totalDog = countDog * onePackDog;
        double totalCat = countCat * onePackCat;
        double totalSum = totalDog + totalCat;
        System.out.println(totalSum + " lv.");
    }
}
