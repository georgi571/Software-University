package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._2Encapsulation._2Exersices._03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            this.products.add(product);
            this.money -= product.getCost();
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", getName(), product.getName()));
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void print(Person person) {
        if (this.products.isEmpty()) {
            System.out.printf("%s - Nothing bought%n",getName());
        } else {
            System.out.printf("%s - ", getName());
            for (int i = 0; i < getProducts().size(); i++) {
                System.out.printf("%s", getProducts().get(i).getName());
                if (i < getProducts().size() - 1) {
                    System.out.printf(", ");
                }
            }
            System.out.printf("%n");
        }
    }
}
