package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._5Polymorphism._1Lab._04WildFarm;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.printf("SQUEEEAAAK!%n");
    }

    @Override
    public void eat(Food food) {
        if (!canEatFood(food)) {
            System.out.printf("Mice are not eating that type of food!%n");
        } else {
            super.eat(food);
        }
    }
}
