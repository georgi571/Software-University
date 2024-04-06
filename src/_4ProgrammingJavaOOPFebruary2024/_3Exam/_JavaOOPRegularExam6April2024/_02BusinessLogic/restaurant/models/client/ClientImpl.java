package _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.models.client;

import java.util.ArrayList;
import java.util.Collection;

import static _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.common.ExceptionMessages.CLIENT_NAME_NULL_OR_EMPTY;

public class ClientImpl implements Client {
    private String name;
    private Collection<String> clientOrders;

    public ClientImpl(String name) {
        this.setName(name);
        this.clientOrders = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(CLIENT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getClientOrders() {
        return this.clientOrders;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
