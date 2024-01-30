package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._1WorkingWithAbstraction._1Lab._04HotelReservation;

public class PriceCalculator {
    public static double calculateFinalPrice(double pricePerDay, int numberOfDays, Season season, DiscountType discountType) {
        double price = pricePerDay * numberOfDays;
        price = price * season.getMultiplier();
        price = price * (100 - discountType.getDiscount()) / 100.0;
        return price;
    }
}
