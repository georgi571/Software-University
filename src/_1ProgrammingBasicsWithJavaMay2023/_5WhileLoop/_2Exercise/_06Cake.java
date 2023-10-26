package _1ProgrammingBasicsWithJavaMay2023._5WhileLoop._2Exercise;

import java.util.Scanner;

public class _06Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int cakePieces = length * width;
        String command = scanner.nextLine();
        while (!command.equals("STOP")) {
            int pieces = Integer.parseInt(command);
            cakePieces = cakePieces - pieces;
            if (cakePieces <= 0) {
                break;
            }
            command = scanner.nextLine();
        }
        if (cakePieces <= 0) {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(cakePieces));
        } else {
            System.out.printf("%d pieces are left.", cakePieces);
        }
    }
}
