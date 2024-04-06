package _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.models.waiter;

import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.models.orders.TakenOrders;

public interface Waiter {
    String getName();

    int getEfficiency();

    boolean canWork();

    TakenOrders takenOrders();


    void work();
}
