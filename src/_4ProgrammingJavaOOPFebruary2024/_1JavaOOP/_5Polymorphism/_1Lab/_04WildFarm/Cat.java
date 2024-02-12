package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._5Polymorphism._1Lab._04WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }
    @Override
    public void makeSound() {
        System.out.printf("Meowwww%n");
    }
    @Override
    public boolean canEatFood(Food food) {
        return true;
    }
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %s, %d]",getClass().getSimpleName(), super.getAnimalName(), this.breed, decimalFormat.format(super.getAnimalWeight()), super.getLivingRegion() ,super.getFoodEaten());
    }
}
