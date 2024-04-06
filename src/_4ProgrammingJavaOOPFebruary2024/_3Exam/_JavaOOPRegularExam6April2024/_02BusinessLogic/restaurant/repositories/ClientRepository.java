package _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.repositories;

import _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._02BusinessLogic.restaurant.models.client.Client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ClientRepository implements Repository<Client> {
    private Collection<Client> clients;

    public ClientRepository() {
        this.clients = new ArrayList<>();
    }

    @Override
    public Collection<Client> getCollection() {
        return Collections.unmodifiableCollection(clients);
    }

    @Override
    public void add(Client client) {
        this.clients.add(client);
    }

    @Override
    public boolean remove(Client client) {
        if (this.clients.contains(client)) {
            this.clients.remove(client);
            return true;
        }
        return false;
    }

    @Override
    public Client byName(String name) {
        for (Client client : this.clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }
}
