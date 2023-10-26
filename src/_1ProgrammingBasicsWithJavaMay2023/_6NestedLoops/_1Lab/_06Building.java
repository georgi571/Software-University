package _1ProgrammingBasicsWithJavaMay2023._6NestedLoops._1Lab;

import java.util.Scanner;

public class _06Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfFloors = Integer.parseInt(scanner.nextLine());
        int numberOfRooms = Integer.parseInt(scanner.nextLine());
        for (int f = numberOfFloors; f >= 1 ; f--) {
            for (int r = 0; r <= numberOfRooms-1 ; r++) {
                if (f == numberOfFloors) {
                    System.out.printf("L%d%d ",f, r);
                } else if (f % 2 == 0){
                    System.out.printf("O%d%d ",f, r);
                } else {
                    System.out.printf("A%d%d ", f, r);
                }
            }
            System.out.println();
        }
    }
}
