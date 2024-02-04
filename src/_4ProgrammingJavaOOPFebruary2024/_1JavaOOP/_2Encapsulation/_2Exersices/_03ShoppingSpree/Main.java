package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._2Encapsulation._2Exersices._03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        String[] peoples = scanner.nextLine().split(";");
        String[] products = scanner.nextLine().split(";");
        for (String people : peoples) {
            String[] peopleInfo = people.split("=");
            Person person = new Person(peopleInfo[0], Double.parseDouble(peopleInfo[1]));
            personList.add(person);
        }
        for (String product : products) {
            String[] productInfo = product.split("=");
            Product currentProduct = new Product(productInfo[0], Double.parseDouble(productInfo[1]));
            productList.add(currentProduct);
        }
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commandParts = command.split("\\s+");
            for (Person person : personList) {
                if (person.getName().equals(commandParts[0])) {
                    for (Product product : productList) {
                        if (product.getName().equals(commandParts[1])) {
                            person.buyProduct(product);
                        }
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (Person person : personList) {
            person.print(person);
        }
    }
}
