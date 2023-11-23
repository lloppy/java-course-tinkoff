package edu.hw7.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class SynchronizedDatabase implements PersonDatabase {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<Integer, Person> database = new HashMap<>();

    SynchronizedDatabase() {
    }

    @Override
    public synchronized void add(final Person person) {
        lock.writeLock().lock();
        try {
            database.put(person.id(), person);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public synchronized void delete(final int id) {
        lock.writeLock().lock();
        try {
            database.remove(id);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public synchronized List<Person> findByName(final String name) {
        lock.readLock().lock();
        try {
            return database.values().stream()
                .filter(person -> notNullAttributes(person)
                    && person.name().equals(name))
                .toList();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public synchronized List<Person> findByAddress(final String address) {
        lock.readLock().lock();
        try {
            return database.values().stream()
                .filter(person -> notNullAttributes(person)
                    && person.address().equals(address))
                .toList();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public synchronized List<Person> findByPhone(final String phone) {
        lock.readLock().lock();
        try {
            return database.values().stream()
                .filter(person -> notNullAttributes(person)
                    && person.phoneNumber().equals(phone))
                .toList();
        } finally {
            lock.readLock().unlock();
        }
    }

    private boolean notNullAttributes(final Person person) {
        return person.address() != null
            && person.phoneNumber() != null
            && person.name() != null;
    }

    public int getSize() {
        lock.readLock().lock();
        try {
            return database.size();
        } finally {
            lock.readLock().unlock();
        }
    }
}
