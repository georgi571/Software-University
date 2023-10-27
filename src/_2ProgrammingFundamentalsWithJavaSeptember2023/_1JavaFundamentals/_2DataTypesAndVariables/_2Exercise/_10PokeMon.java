package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._2DataTypesAndVariables._2Exercise;

import java.util.Scanner;

public class _10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int powerLeft = power;
        int pokedTarget = 0;
        while (powerLeft >= distance){
            powerLeft -= distance;
            pokedTarget++;
            if (exhaustionFactor != 0) {
                if (powerLeft == power / 2) {
                    powerLeft = powerLeft /exhaustionFactor;
                }
            }
        }
        System.out.printf("%d%n%d",powerLeft, pokedTarget);
    }
}
