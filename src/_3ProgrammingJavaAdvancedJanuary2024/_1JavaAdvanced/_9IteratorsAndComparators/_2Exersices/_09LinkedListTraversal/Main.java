package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._9IteratorsAndComparators._2Exersices._09LinkedListTraversal;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        while (number > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input[0].equals("Add")) {
                list.add(Integer.parseInt(input[1]));
            } else {
                list.remove(Integer.parseInt(input[1]));
            }
            number--;
        }
        System.out.printf("%d%n",list.getSize());
        for (Integer element : list) {
            System.out.printf("%d ", element);
        }
    }
}
