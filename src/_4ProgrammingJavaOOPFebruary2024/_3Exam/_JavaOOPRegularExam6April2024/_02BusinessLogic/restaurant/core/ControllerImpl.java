package _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.core;

import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.models.client.Client;
import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.models.client.ClientImpl;
import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.models.waiter.FullTimeWaiter;
import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.models.waiter.HalfTimeWaiter;
import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.models.waiter.Waiter;
import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.models.working.WorkingImpl;
import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.repositories.ClientRepository;
import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.repositories.Repository;
import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.repositories.WaiterRepository;

import static _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Waiter> waiters;
    private Repository<Client> clients;
    private int servedClients;

    public ControllerImpl() {
        this.waiters = new WaiterRepository();
        this.clients = new ClientRepository();
        this.servedClients = 0;
    }

    @Override
    public String addWaiter(String type, String waiterName) {
        Waiter waiter;
        if (type.equals("FullTimeWaiter")) {
            waiter = new FullTimeWaiter(waiterName);
        } else if (type.equals("HalfTimeWaiter")) {
            waiter = new HalfTimeWaiter(waiterName);
        } else {
            throw new IllegalArgumentException(WAITER_INVALID_TYPE);
        }
        this.waiters.add(waiter);
        return String.format(WAITER_ADDED, type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {
        Client client = new ClientImpl(clientName);
        for (String order : orders) {
            client.getClientOrders().add(order);
        }
        this.clients.add(client);
        return String.format(CLIENT_ADDED, clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = this.waiters.byName(waiterName);
        if (waiter == null) {
            throw new IllegalArgumentException(String.format(WAITER_DOES_NOT_EXIST, waiterName));
        }
        this.waiters.remove(waiter);
        return String.format(WAITER_REMOVE, waiterName);
    }

    @Override
    public String removeClient(String clientName) {
        Client client = this.clients.byName(clientName);
        if (client == null) {
            throw new IllegalArgumentException(String.format(CLIENT_DOES_NOT_EXIST, clientName));
        }
        this.clients.remove(client);
        return String.format(CLIENT_REMOVE, clientName);
    }

    @Override
    public String startWorking(String clientName) {
        if (this.waiters.getCollection().isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }
        Client client = this.clients.byName(clientName);
        WorkingImpl working = new WorkingImpl();
        working.takingOrders(client, this.waiters.getCollection());
        this.servedClients++;
        return String.format(ORDERS_SERVING, clientName);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format(FINAL_CLIENTS_COUNT, servedClients)).append(System.lineSeparator());
        statistics.append(FINAL_WAITERS_STATISTICS).append(System.lineSeparator());
        for (Waiter waiter : this.waiters.getCollection()) {
            statistics.append(String.format(FINAL_WAITER_NAME, waiter.getName())).append(System.lineSeparator());
            statistics.append(String.format(FINAL_WAITER_EFFICIENCY, waiter.getEfficiency())).append(System.lineSeparator());
            if (waiter.takenOrders().getOrdersList().isEmpty()) {
                statistics.append(String.format(FINAL_WAITER_ORDERS, "none")).append(System.lineSeparator());
            } else {
                statistics.append(String.format(FINAL_WAITER_ORDERS, String.join(FINAL_WAITER_ORDERS_DELIMITER, waiter.takenOrders().getOrdersList()))).append(System.lineSeparator());
            }
        }
        return statistics.toString().trim();
    }
}
