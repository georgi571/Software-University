package _1ProgrammingBasicsWithJavaMay2023._8Exam._2OtherExam;

import java.util.Scanner;

public class _04GiftsFromSanta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int S = Integer.parseInt(scanner.nextLine());
        for (int i = M; i >= N; i--) {
            if (i % 2 == 0 && i % 3 == 0){
                if (i == S) {
                    break;
                } else {
                    System.out.printf("%d ", i);
                }
            }
        }
    }
}