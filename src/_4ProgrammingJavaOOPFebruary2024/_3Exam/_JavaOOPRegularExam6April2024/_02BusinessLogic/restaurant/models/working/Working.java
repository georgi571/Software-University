package _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.models.working;

import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.models.client.Client;
import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.models.waiter.Waiter;

import java.util.Collection;

public interface Working {
    void takingOrders(Client client, Collection<Waiter> waiters);

}
