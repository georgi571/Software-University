package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._2Encapsulation._2Exersices._04PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") || toppingType.equals("Veggies") || toppingType.equals("Cheese") || toppingType.equals("Sauce")) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
    }

    public double calculateCalories() {
        double toppingCaloriesCoefficient = getToppingCaloriesCoefficient(this.toppingType);
        return (2 * this.weight) * toppingCaloriesCoefficient;
    }

    private double getToppingCaloriesCoefficient(String toppingType) {
        double toppingCaloriesCoefficient = 0;
        if (this.toppingType.equals("Meat")) {
            toppingCaloriesCoefficient = 1.2;
        } else if (this.toppingType.equals("Veggies")) {
            toppingCaloriesCoefficient = 0.8;
        } else if (this.toppingType.equals("Cheese")) {
            toppingCaloriesCoefficient = 1.1;
        } else if (this.toppingType.equals("Sauce")) {
            toppingCaloriesCoefficient = 0.9;
        }
        return toppingCaloriesCoefficient;
    }
}
