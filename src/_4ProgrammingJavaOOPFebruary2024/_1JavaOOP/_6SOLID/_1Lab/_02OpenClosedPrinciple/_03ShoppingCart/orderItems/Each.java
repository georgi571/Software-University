package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._02OpenClosedPrinciple._03ShoppingCart.orderItems;

public class Each extends OrderItem {
    @Override
    public double getItemPrice(){
        return this.getQuantity() * 5.0;
    }
}
