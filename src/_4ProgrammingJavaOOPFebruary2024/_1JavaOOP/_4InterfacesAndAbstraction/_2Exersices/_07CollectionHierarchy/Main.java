package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._07CollectionHierarchy;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._07CollectionHierarchy.entities.AddCollection;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._07CollectionHierarchy.entities.AddRemoveCollection;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._07CollectionHierarchy.entities.MyListImpl;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._07CollectionHierarchy.interfaces.AddRemovable;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._07CollectionHierarchy.interfaces.Addable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();
        String[] input = scanner.nextLine().split("\\s+");
        printIndexes(addCollection, input);
        printIndexes(addRemoveCollection, input);
        printIndexes(myList, input);
        int itemsToRemove = Integer.parseInt(scanner.nextLine());
        printRemove(addRemoveCollection, itemsToRemove);
        printRemove(myList, itemsToRemove);
    }
    private static void printRemove(AddRemovable collection, int rotation) {
        for (int i = 0; i < rotation; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }
    private static void printIndexes(Addable addCollection, String[] input) {
        for (String item : input) {
            System.out.print(addCollection.add(item) + " ");
        }
        System.out.println();
    }
}
