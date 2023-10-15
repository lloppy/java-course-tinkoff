package edu.hw2.task3.connection.manager;

import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connection.faulty.FaultyConnection;
import edu.hw2.task3.connection.StableConnection;

public final class DefaultConnectionManager implements ConnectionManager {
    private final double controllerOfFaultyProbability;

    public DefaultConnectionManager(final double controllerProbability) {
        this.controllerOfFaultyProbability = controllerProbability;
    }

    @Override
    public Connection getConnection() {
        if (Math.random() < controllerOfFaultyProbability) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
