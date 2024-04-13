package _1ProgrammingBasicsWithJavaMay2023._7PBExamsPreparation._ProgrammingBasicsOnlineExampleExam4;

import java.util.Scanner;

public class _06FavoriteMovie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameForFavoriteMovie = "";
        int pointsForFavoriteMovie = 0;
        for (int i = 0; i < 7; i++) {
            String currentMovieName = scanner.nextLine();
            if (currentMovieName.equals("STOP")) {
                break;
            }
            if (i == 6) {
                System.out.printf("The limit is reached.%n");
            }
            int pointsForCurrentMovie = 0;
            for (int j = 0; j < currentMovieName.length(); j++) {
                char currentChar = currentMovieName.charAt(j);
                int pointsFromCurrentChar = currentChar;
                if (Character.isUpperCase(currentChar)) {
                    pointsForCurrentMovie += pointsFromCurrentChar - currentMovieName.length();
                } else if (Character.isLowerCase(currentChar)){
                    pointsForCurrentMovie += pointsFromCurrentChar - (currentMovieName.length() * 2);
                } else {
                    pointsForCurrentMovie += currentChar;
                }
            }
            if (pointsForFavoriteMovie < pointsForCurrentMovie) {
                pointsForFavoriteMovie = pointsForCurrentMovie;
                nameForFavoriteMovie = currentMovieName;
            }
        }
        System.out.printf("The best movie for you is %s with %d ASCII sum.", nameForFavoriteMovie, pointsForFavoriteMovie);
    }
}
