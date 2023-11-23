package edu.hw7.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SynchronizedDatabase implements PersonDatabase {
    Map<Integer, Person> database = new HashMap<>();

    SynchronizedDatabase() {
    }

    @Override
    public synchronized void add(final Person person) {
        database.put(person.id(), person);
    }

    @Override
    public synchronized void delete(final int id) {
        database.remove(id);
    }

    @Override
    public synchronized List<Person> findByName(final String name) {
        return database.values().stream()
            .filter(person -> notNullAttributes(person) && person.name().equals(name))
            .toList();
    }

    @Override
    public synchronized List<Person> findByAddress(final String address) {
        return database.values().stream()
            .filter(person -> notNullAttributes(person) && person.address().equals(address))
            .toList();
    }

    @Override
    public synchronized List<Person> findByPhone(final String phone) {
        return database.values().stream()
            .filter(person -> notNullAttributes(person) && person.phoneNumber().equals(phone))
            .toList();
    }

    private boolean notNullAttributes(final Person person) {
        return person.address() != null
            && person.phoneNumber() != null
            && person.name() != null;
    }

    public int getSize() {
        return database.size();
    }
}
