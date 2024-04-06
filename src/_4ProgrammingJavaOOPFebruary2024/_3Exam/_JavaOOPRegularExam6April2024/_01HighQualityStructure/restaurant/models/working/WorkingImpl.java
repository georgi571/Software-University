package _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._01HighQualityStructure.restaurant.models.working;

import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._01HighQualityStructure.restaurant.models.client.Client;
import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._01HighQualityStructure.restaurant.models.waiter.Waiter;

import java.util.Collection;

public class WorkingImpl implements Working {
    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {
        Collection<String> clientOrders = client.getClientOrders();
        for (Waiter waiter : waiters) {
            while (waiter.canWork() && !clientOrders.isEmpty()) {
                waiter.work();
                String order = clientOrders.iterator().next();
                waiter.takenOrders().getOrdersList().add(order);
                clientOrders.remove(order);
            }
        }
    }
}
