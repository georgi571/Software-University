package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._04JavaAdvancedRetakeExam9August2023._03VendingMachine.vendingSystem;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }
    public int getCount() {
        return this.drinks.size();
    }

    public void addDrink(Drink drink) {
        if (this.drinks.size() < buttonCapacity) {
            this.drinks.add(drink);
        }
    }
    public boolean removeDrink(String name) {
        for (Drink drink : this.drinks) {
            if (drink.getName().equals(name)) {
                return this.drinks.remove(drink);
            }
        }
        return false;
    }
    public Drink getLongest() {
        Drink getLongest = null;
        for (Drink drink : this.drinks) {
            if (getLongest == null) {
                getLongest = drink;
            } else if (drink.getVolume() > getLongest.getVolume()) {
                getLongest = drink;
            }
        }
        return getLongest;
    }
    public Drink getCheapest() {
        Drink getCheapest = null;
        for (Drink drink : this.drinks) {
            if (getCheapest == null) {
                getCheapest = drink;
            } else if (drink.getVolume() < getCheapest.getVolume()) {
                getCheapest = drink;
            }
        }
        return getCheapest;
    }
    public String buyDrink(String name){
        Drink buyDrink = null;
        for (Drink drink : this.drinks) {
            if (drink.getName().equals(name)) {
                buyDrink = drink;
            }
        }
        return buyDrink.toString();
    }
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Drinks available:\n");
        for (Drink drink : this.drinks) {
            stringBuilder.append(drink + "\n");
        }
        return stringBuilder.toString();
    }
}
