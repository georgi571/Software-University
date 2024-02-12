package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._5Polymorphism._1Lab._04WildFarm;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.printf("Zs%n");
    }
}
