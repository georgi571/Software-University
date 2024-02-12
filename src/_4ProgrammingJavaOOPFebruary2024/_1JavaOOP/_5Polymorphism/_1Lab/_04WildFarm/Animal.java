package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._5Polymorphism._1Lab._04WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public abstract void makeSound();
    public abstract boolean canEatFood(Food food);
    public void eat(Food food) {
        if (canEatFood(food)) {
            foodEaten += food.getQuantity();
        } else {
            System.out.printf("%ss are not eating that type of food!%n",getClass().getSimpleName());
        }
    }
}
