package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._02OpenClosedPrinciple._03ShoppingCart.orderItems;

public class Weight extends OrderItem {
    @Override
    public double getItemPrice(){
        return this.getQuantity() * 4.0 / 1000;
    }
}
