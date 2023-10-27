package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._2DataTypesAndVariables._2Exercise;

import java.util.Scanner;

public class _11Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSnowBalls = Integer.parseInt(scanner.nextLine());
        double highestSnowBallValue = 0;
        int bestSnowBallSnow = 0;
        int bestSnowBallTime = 0;
        int bestSnowBallQuality = 0;
        for (int i = 1; i <= numberOfSnowBalls ; i++) {
            int snowBallSnow = Integer.parseInt(scanner.nextLine());
            int snowBallTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double snowBallValue = Math.pow((snowBallSnow / snowBallTime), snowballQuality);
            if (snowBallValue > highestSnowBallValue) {
                highestSnowBallValue = snowBallValue;
                bestSnowBallSnow = snowBallSnow;
                bestSnowBallTime = snowBallTime;
                bestSnowBallQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",bestSnowBallSnow, bestSnowBallTime, highestSnowBallValue, bestSnowBallQuality);
    }
}
