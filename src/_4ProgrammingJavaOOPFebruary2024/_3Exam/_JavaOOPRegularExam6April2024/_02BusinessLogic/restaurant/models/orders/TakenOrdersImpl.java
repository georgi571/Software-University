package _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.models.orders;

import java.util.ArrayList;
import java.util.Collection;

public class TakenOrdersImpl implements TakenOrders{
    private Collection<String> ordersList;

    public TakenOrdersImpl() {
        this.ordersList = new ArrayList<>();
    }

    @Override
    public Collection<String> getOrdersList() {
        return this.ordersList;
    }
}
