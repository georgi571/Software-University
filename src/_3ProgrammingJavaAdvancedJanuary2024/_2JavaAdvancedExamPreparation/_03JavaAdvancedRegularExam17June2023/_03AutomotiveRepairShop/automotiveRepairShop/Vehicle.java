package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._03JavaAdvancedRegularExam17June2023._03AutomotiveRepairShop.automotiveRepairShop;

public class Vehicle {
        private String VIN;
        private int mileage;
        private String damage;

    public Vehicle(String VIN, int mileage, String damage) {
        this.VIN = VIN;
        this.mileage = mileage;
        this.damage = damage;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVin(String VIN) {
        this.VIN = VIN;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return String.format("Damage: %s, Vehicle: %s (%d km)",getDamage(), getVIN(), getMileage());
    }
}
