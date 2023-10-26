package _1ProgrammingBasicsWithJavaMay2023._5WhileLoop._2Exercise;

import java.util.Scanner;

public class _01OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameOfFavoriteBook = scanner.nextLine();
        int numberOfBooks = 0;
        boolean isFound = false;
        String findBook = scanner.nextLine();
        while (!findBook.equals("No More Books")) {
            if (findBook.equals(nameOfFavoriteBook)) {
                isFound = true;
                break;
            }
            numberOfBooks++;
            findBook = scanner.nextLine();
        }
        if (isFound == true) {
            System.out.printf("You checked %d books and found it.", numberOfBooks);
        } else {
            System.out.printf("The book you search is not here!%n");
            System.out.printf("You checked %d books.", numberOfBooks);
        }
    }
}
